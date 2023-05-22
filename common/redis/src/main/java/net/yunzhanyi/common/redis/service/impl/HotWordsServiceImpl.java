package net.yunzhanyi.common.redis.service.impl;

import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.core.vo.HotWord;
import net.yunzhanyi.common.redis.service.HotWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author bestct
 * @date 2023/5/22
 * description: TODO
 */
@Service
public class HotWordsServiceImpl implements HotWordsService {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 添加热词
     * 设置缓存失效时间，统一为凌晨零点
     *
     * @param hotWord 热词
     * @param score   分数
     */
    @Override
    public void addHotWord(String hotWord, int score) {

        redisTemplate.opsForZSet().incrementScore("hotWord", hotWord, score);
        // 加入排序set
    }


    /**
     * 变热词
     *
     * @param size 大小
     * @return {@link List}<{@link HotWord}>
     */
    @Override
    public List<HotWord> getHotWord(int size) {
        List<HotWord> hotWordList = new ArrayList<>();
        Set<ZSetOperations.TypedTuple<Object>> typedTupleSet = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("hotWord", 1, 100);
        Iterator<ZSetOperations.TypedTuple<Object>> iterator = typedTupleSet.iterator();
        int flag = 0;
        while (iterator.hasNext()) {
            flag++;
            ZSetOperations.TypedTuple<Object> typedTuple = iterator.next();
            String value = (String) typedTuple.getValue();
            int score = (int) Math.ceil(typedTuple.getScore());
            HotWord hotWord = new HotWord(score, value);
            hotWordList.add(hotWord);
            if (flag >= size) {
                break;
            }
        }
        return hotWordList;
    }

    /**
     * 删除热词
     *
     * @param index 指数
     */
    @Override
    public void deleteHotWord(int index) {
        List<HotWord> hotWords = getHotWord(index);
        if (hotWords==null||hotWords.isEmpty()){
            return;
        }
        HotWord endHotWord = hotWords.get(hotWords.size() - 1);
        long rank = redisTemplate.opsForZSet().rank(CacheConstants.HOT_WORD_KEY, endHotWord.value);
        redisTemplate.opsForZSet().removeRange(CacheConstants.HOT_WORD_KEY, 0, rank - 1);
        for (HotWord hotWord : hotWords) {
            redisTemplate.opsForZSet().incrementScore(CacheConstants.HOT_WORD_KEY, hotWord.value, -(endHotWord.score - 1));
        }
    }
}

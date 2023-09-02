package net.yunzhanyi.client.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import net.yunzhanyi.client.service.*;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.core.vo.HotWord;
import net.yunzhanyi.common.redis.service.HotWordsService;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.domain.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bestct
 * @date 2023/5/22
 * description: TODO
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private RedisService redisService;

    @Autowired
    private PoetryService poetryService;
    @Autowired
    private PartService partService;

    @Autowired
    private TagService tagService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private HotWordsService hotWordsService;

    @Autowired
    private AnthologyService anthologyService;

    @PostConstruct
    private void init() {
        List<Object> cacheList;

        //加载诗词名句缓存
        cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_PARTS);
        if (CollectionUtils.isEmpty(cacheList)) {
            List<Part> parts = partService.searchPartRandom(5);
            redisService.setCacheList(CacheConstants.REDIS_INDEX_PARTS, parts);
        }

        //加载诗词标签缓存
        cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_TAGS);
        if (CollectionUtils.isEmpty(cacheList)) {
            List<Tag> tagVos = tagService.initTag();
            tagVos.add(0, new Tag(0, "全部"));
            redisService.setCacheList(CacheConstants.REDIS_INDEX_TAGS, tagVos);
        }

        cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_DYNASTIES);
        if (CollectionUtils.isEmpty(cacheList)) {
            List<Dynasty> dynasties = poetryService.initDynasty();
            dynasties.add(0, new Dynasty(0, "全部"));
            redisService.setCacheList(CacheConstants.REDIS_INDEX_DYNASTIES, dynasties);
        }

        cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_AUTHORS);
        if (CollectionUtils.isEmpty(cacheList)) {
            List<Author> authors = authorService.searchAuthorRandom(30);
            redisService.setCacheList(CacheConstants.REDIS_INDEX_AUTHORS, authors);
        }
        cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_HOT_AUTHORS);
        if (CollectionUtils.isEmpty(cacheList)) {
            List<Author> authors = JSON.parseArray("[{\"authorName\":\"李白\",\"id\":4265},{\"authorName\":\"杜甫\",\"id\":4266},{\"authorName\":\"白居易\",\"id\":4267},{\"authorName\":\"辛弃疾\",\"id\":6736},{\"authorName\":\"王维\",\"id\":4276},{\"authorName\":\"李清照\",\"id\":6744},{\"authorName\":\"陆游\",\"id\":6748},{\"authorName\":\"王勃\",\"id\":4283},{\"authorName\":\"毛泽东\",\"id\":22835},{\"authorName\":\"曹操\",\"id\":3158},{\"authorName\":\"韩愈\",\"id\":4284},{\"authorName\":\"屈原\",\"id\":4001},{\"authorName\":\"曹植\",\"id\":3160},{\"authorName\":\"张九龄\",\"id\":4291},{\"authorName\":\"岑参\",\"id\":4285},{\"authorName\":\"李煜\",\"id\":3264},{\"authorName\":\"韦庄\",\"id\":4288},{\"authorName\":\"王建\",\"id\":4320},{\"authorName\":\"范仲淹\",\"id\":6747},{\"authorName\":\"岳飞\",\"id\":6756},{\"authorName\":\"马致远\",\"id\":3333},{\"authorName\":\"陈子昂\",\"id\":4277},{\"authorName\":\"张若虚\",\"id\":4310},{\"authorName\":\"郑燮\",\"id\":17097},{\"authorName\":\"龚自珍\",\"id\":17095},{\"authorName\":\"崔颢\",\"id\":4300},{\"authorName\":\"冯延巳\",\"id\":3265},{\"authorName\":\"刘长卿\",\"id\":4294},{\"authorName\":\"杨万里\",\"id\":6743},{\"authorName\":\"赵师秀\",\"id\":6820},{\"authorName\":\"贾岛\",\"id\":4279},{\"authorName\":\"杨炯\",\"id\":4304},{\"authorName\":\"睢景臣\",\"id\":3339},{\"authorName\":\"王绩\",\"id\":4332},{\"authorName\":\"晏殊\",\"id\":6745},{\"authorName\":\"柳宗元\",\"id\":4280},{\"authorName\":\"梅尧臣\",\"id\":6741},{\"authorName\":\"高鼎\",\"id\":17143},{\"authorName\":\"黄庭坚\",\"id\":6738}]", Author.class);
            redisService.setCacheList(CacheConstants.REDIS_INDEX_HOT_AUTHORS, authors);
        }
        cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_POETRIES);
        if (CollectionUtils.isEmpty(cacheList)) {
            List<Poetry> poetry = poetryService.searchPoetryRandom(40);
            redisService.setCacheList(CacheConstants.REDIS_INDEX_POETRIES, poetry);
        }
        cacheList=redisService.getCacheList(CacheConstants.REDIS_INDEX_ANTHOLOGY);
        if (CollectionUtils.isEmpty(cacheList)) {
            List<Anthology> anthologies = anthologyService.searchIndexAnthology();
            redisService.setCacheList(CacheConstants.REDIS_INDEX_ANTHOLOGY, anthologies);
        }

        Object cacheObject = redisService.getCacheObject(CacheConstants.REDIS_INDEX_POETRY);
        if (ObjectUtil.isEmpty(cacheObject)) {
            Poetry poetry = poetryService.getPoetryByRandom();
            redisService.setCacheObject(CacheConstants.REDIS_INDEX_POETRY, poetry);
        }
    }


    @Override
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<>(6);
        List<Part> partList = redisService.getCacheList(CacheConstants.REDIS_INDEX_PARTS);
        List<Author> authorList = redisService.getCacheList(CacheConstants.REDIS_INDEX_AUTHORS);
        List<Author> hotAuthorList = redisService.getCacheList(CacheConstants.REDIS_INDEX_HOT_AUTHORS);
        List<Poetry> poetryList = redisService.getCacheList(CacheConstants.REDIS_INDEX_POETRIES);
        Poetry poetry = redisService.getCacheObject(CacheConstants.REDIS_INDEX_POETRY);
        List<HotWord> hotWords = hotWordsService.getHotWord(10);
        List<Anthology> anthologies=redisService.getCacheList(CacheConstants.REDIS_INDEX_ANTHOLOGY);
        map.put("indexPoetry", poetry);
        map.put("partList", partList);
        map.put("authorList", authorList);
        map.put("hotAuthorList", hotAuthorList);
        map.put("poetryList", poetryList);
        map.put("hotWordList", hotWords);
        map.put("anthologyList",anthologies);
        return map;
    }

    @Override
    public List<Author> indexApiAuthor(Integer dynasty) {
        return authorService.selectAllAuthor(dynasty);
    }

    @Override
    public List<Poetry> indexApiPoetry(Integer dynasty, Integer tagId) {
        return poetryService.indexApiPoetry(dynasty,tagId);
    }

    @Override
    public List<Tag> getTagList(Integer tagId) {
        List<Tag> tagVos = redisService.getCacheList(CacheConstants.REDIS_INDEX_TAGS);
        List<Tag> tags = tagService.checkTagId(tagId, tagVos);
        return tags;
    }

    @Override
    public Map<String, Object> indexApi() {
        List<Part> partList = redisService.getCacheList(CacheConstants.REDIS_INDEX_PARTS);
        Poetry poetry = redisService.getCacheObject(CacheConstants.REDIS_INDEX_POETRY);
        Map<String, Object> indexMap = new HashMap<>(3);
        indexMap.put("partList", partList);
        indexMap.put("indexPoetry", poetry);
        return indexMap;
    }
}

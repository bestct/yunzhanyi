package net.yunzhanyi.common.redis.service;

import net.yunzhanyi.common.core.vo.HotWord;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/22
 * description: TODO
 */
public interface HotWordsService {
    /**
     * 添加热词
     *
     * @param hotWord 热词
     * @param score   分数
     */
    void addHotWord(String hotWord, int score);

    /**
     * 变热词
     *
     * @param size 大小
     * @return {@link List}<{@link HotWord}>
     */
    List<HotWord> getHotWord(int size);

    /**
     * 删除热词
     *
     * @param index 指数
     */
    void deleteHotWord(int index);
}

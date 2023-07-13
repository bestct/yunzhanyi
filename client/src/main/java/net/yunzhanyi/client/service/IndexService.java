package net.yunzhanyi.client.service;

import net.yunzhanyi.domain.pojo.Author;
import net.yunzhanyi.domain.pojo.Poetry;
import net.yunzhanyi.domain.pojo.Tag;

import java.util.List;
import java.util.Map;

/**
 * 索引服务
 *
 * @author bestct
 * @date 2023/05/22
 */
public interface IndexService {

    /**
     * 指数
     *
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> index();

    /**
     * 诗歌指数
     *
     * @param dynasty  王朝
     * @param tagId    标签id
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> poetryIndex(Integer dynasty, Integer tagId, Integer pageNum, Integer pageSize);

    /**
     * 作者索引
     *
     * @param dynasty  王朝
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> authorIndex(Integer dynasty, Integer pageNum, Integer pageSize);

    /**
     * 指数api作者
     *
     * @param dynasty 王朝
     * @return {@link List}<{@link Author}>
     */
    List<Author> indexApiAuthor(Integer dynasty);

    /**
     * 指数api诗歌
     *
     * @param dynasty 王朝
     * @param tagId   标签id
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> indexApiPoetry(Integer dynasty, Integer tagId);

    /**
     * 得到标记列表
     *
     * @param tagId 标签id
     * @return {@link List}<{@link Tag}>
     */
    List<Tag> getTagList(Integer tagId);
}

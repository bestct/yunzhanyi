package net.yunzhanyi.client.service;

import net.yunzhanyi.client.domain.dto.CollectionDto;

import java.util.List;

/**
 * @author bestct
 * @date 2023/7/18
 * description: TODO
 */
public interface CollectionService {
    /**
     * 获取用户api集合
     *
     * @param userid         用户标识
     * @param collectionType 集合类型
     * @param pageNum        页面num
     * @param pageSize       页面大小
     * @return {@link List}<{@link CollectionDto}>
     */
    List<CollectionDto> getUserApiCollection(Long userid, Integer collectionType, Integer pageNum, Integer pageSize);

    /**
     * 添加收藏
     *
     * @param resId          res id
     * @param userid         用户标识
     * @param collectionType 集合类型
     */
    void addCollection(Long resId, Long userid, Integer collectionType);

    /**
     * 取消收藏id
     *
     * @param colId 坳id
     */
    void cancelCollectionById(Long colId);

    /**
     * 再通过id集合
     *
     * @param colId 坳id
     */
    void reCollectionById(Long colId);

    /**
     * 取消收藏
     *
     * @param resId          res id
     * @param userid         用户标识
     * @param collectionType 集合类型
     */
    void cancelCollection(Long resId, Long userid, Integer collectionType);

    /**
     * 收集
     *
     * @param uid            uid
     * @param poetryId       诗歌id
     * @param collectionType 集合类型
     * @return {@link Boolean}
     */
    Boolean isCollected(long uid, Long poetryId, Integer collectionType );
}

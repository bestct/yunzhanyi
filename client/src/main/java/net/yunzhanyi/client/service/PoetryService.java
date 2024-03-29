package net.yunzhanyi.client.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.client.domain.vo.PoetryVo;
import net.yunzhanyi.common.core.vo.PageVo;
import net.yunzhanyi.domain.pojo.Dynasty;
import net.yunzhanyi.domain.pojo.Poetry;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */

public interface PoetryService {
    /**
     * 被随机诗歌
     *
     * @return {@link Poetry}
     */
    Poetry getPoetryByRandom();

    /**
     * 随机搜索诗歌
     *
     * @param i 我
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> searchPoetryRandom(int i);

    /**
     * init王朝
     *
     * @return {@link List}<{@link Dynasty}>
     */
    List<Dynasty> initDynasty();

    /**
     * 搜索诗歌
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> searchPoetry(String keyword);

    /**
     * 复制页面信息
     *
     * @param poetryPageInfo 诗歌页面信息
     * @return {@link PageVo}
     */
    PageVo copyPageInfo(PageInfo<Poetry> poetryPageInfo);

    /**
     * 通过id搜索网络诗歌
     *
     * @param poetryId 诗歌id
     * @return {@link PoetryVo}
     */
    PoetryVo searchWebPoetryById(Long poetryId);

    /**
     * 诗歌作者id
     *
     * @param authorId  作者id
     * @param searchVal 搜索瓦尔
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> getPoetryByAuthorId(Long authorId, String searchVal);

    /**
     * 指数api诗歌
     *
     * @param dynasty 王朝
     * @param tagId   标签id
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> indexApiPoetry(Integer dynasty, Integer tagId);

    /**
     * 搜索诗歌通过id
     *
     * @param poetryId 诗歌id
     * @return {@link PoetryVo}
     */
    PoetryVo searchPoetryById(Long poetryId);

}

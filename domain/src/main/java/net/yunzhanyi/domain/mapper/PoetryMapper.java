package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Poetry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bestct
* @description 针对表【poetry】的数据库操作Mapper
* @createDate 2023-05-05 13:52:17
* @Entity net.yunzhanyi.domain.pojo.Poetry
*/

@Mapper
public interface PoetryMapper {

    /**
     * 按主键删除
     *
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入
     *
     * @param record 记录
     * @return int
     */
    int insert(Poetry record);

    /**
     * 插入选择性
     *
     * @param record 记录
     * @return int
     */
    int insertSelective(Poetry record);

    /**
     * 选择通过主键
     *
     * @param id id
     * @return {@link Poetry}
     */
    Poetry selectByPrimaryKey(Long id);

    /**
     * 更新主键选择性
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(Poetry record);

    /**
     * 更新主键
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(Poetry record);

    /**
     * 选择列表
     *
     * @param poetry 诗歌
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> selectList(@Param("poetry") Poetry poetry);

    /**
     * 选择数
     *
     * @return {@link Integer}
     */
    Integer selectCount();

    /**
     * 选择随机诗歌
     *
     * @param offset 抵消
     * @return {@link Poetry}
     */
    Poetry selectRandomPoetry(@Param("offset") int offset);

    /**
     * 选择简单诗
     *
     * @param offset 抵消
     * @param size   大小
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> selectPoetrySimple(@Param("offset") int offset, @Param("size") int size);

    /**
     * 选择通过关键字
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> selectByKeyword(@Param("keyword") String keyword);

    /**
     * 通过主键来选择细节
     *
     * @param poetryId 诗歌id
     * @return {@link Poetry}
     */
    Poetry selectWithDetailsByPrimaryKey(@Param("poetryId") Long poetryId);

    List<Poetry> selectByAuthorIdLimit(@Param("authorId") Long authorId, @Param("limit") Integer limit);

    /**
     * 选择作者id
     *
     * @param authorId  作者id
     * @param searchVal 搜索值
     * @return {@link List}<{@link Poetry}>
     */
    List<Poetry> selectByAuthorId(@Param("authorId") Long authorId, @Param("searchVal") String searchVal);
}

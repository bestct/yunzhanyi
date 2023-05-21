package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.PoetryDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bestct
* @description 针对表【poetry_detail】的数据库操作Mapper
* @createDate 2023-05-05 13:52:37
* @Entity net.yunzhanyi.domain.pojo.PoetryDetail
*/
@Mapper
public interface PoetryDetailMapper {

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
    int insert(PoetryDetail record);

    /**
     * 插入选择性
     *
     * @param record 记录
     * @return int
     */
    int insertSelective(PoetryDetail record);

    /**
     * 选择通过主键
     *
     * @param id id
     * @return {@link PoetryDetail}
     */
    PoetryDetail selectByPrimaryKey(Long id);

    /**
     * 更新主键选择性
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(PoetryDetail record);

    /**
     * 更新主键
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(PoetryDetail record);

    /**
     * 选择通过诗歌id
     *
     * @param poetryId 诗歌id
     * @return {@link List}<{@link PoetryDetail}>
     */
    List<PoetryDetail> selectByPoetryId(@Param("poetryId") Long poetryId);

}

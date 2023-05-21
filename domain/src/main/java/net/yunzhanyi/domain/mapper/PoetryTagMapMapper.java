package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.PoetryTagMap;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bestct
* @description 针对表【poetry_tag_map】的数据库操作Mapper
* @createDate 2023-05-05 13:52:46
* @Entity net.yunzhanyi.domain.pojo.PoetryTagMap
*/
@Mapper
public interface PoetryTagMapMapper {

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
    int insert(PoetryTagMap record);

    /**
     * 插入选择性
     *
     * @param record 记录
     * @return int
     */
    int insertSelective(PoetryTagMap record);

    /**
     * 选择通过主键
     *
     * @param id id
     * @return {@link PoetryTagMap}
     */
    PoetryTagMap selectByPrimaryKey(Long id);

    /**
     * 更新主键选择性
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(PoetryTagMap record);

    /**
     * 更新主键
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(PoetryTagMap record);

}

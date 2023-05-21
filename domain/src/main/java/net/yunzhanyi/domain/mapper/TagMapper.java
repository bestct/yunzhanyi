package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bestct
* @description 针对表【tag】的数据库操作Mapper
* @createDate 2023-05-05 13:52:54
* @Entity net.yunzhanyi.domain.pojo.Tag
*/
@Mapper
public interface TagMapper {

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
    int insert(Tag record);

    /**
     * 插入选择性
     *
     * @param record 记录
     * @return int
     */
    int insertSelective(Tag record);

    /**
     * 选择通过主键
     *
     * @param id id
     * @return {@link Tag}
     */
    Tag selectByPrimaryKey(Long id);

    /**
     * 更新主键选择性
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * 更新主键
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(Tag record);

}

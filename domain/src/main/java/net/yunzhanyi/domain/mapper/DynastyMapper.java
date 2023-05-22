package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Dynasty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author bestct
* @description 针对表【dynasty】的数据库操作Mapper
* @createDate 2023-05-06 12:01:39
* @Entity net.yunzhanyi.domain.pojo.Dynasty
*/

@Mapper
public interface DynastyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dynasty record);

    int insertSelective(Dynasty record);

    Dynasty selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dynasty record);

    /**
     * 更新主键
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(Dynasty record);

    /**
     * 选择所有
     *
     * @return {@link List}<{@link Dynasty}>
     */
    List<Dynasty> selectAll();

    /**
     * 选择初始化
     *
     * @return {@link List}<{@link Dynasty}>
     */
    List<Dynasty> selectInit();

}

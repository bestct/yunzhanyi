package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bestct
* @description 针对表【part】的数据库操作Mapper
* @createDate 2023-05-08 16:46:24
* @Entity net.yunzhanyi.domain.pojo.Part
*/

@Mapper
public interface PartMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Part record);

    int insertSelective(Part record);

    Part selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Part record);

    int updateByPrimaryKey(Part record);

    List<Part> selectByPrimaryKeys(@Param("ids") long[] ids);
}

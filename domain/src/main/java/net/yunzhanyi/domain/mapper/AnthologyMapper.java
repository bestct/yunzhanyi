package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Anthology;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bestct
* @description 针对表【anthology】的数据库操作Mapper
* @createDate 2023-05-28 11:30:37
* @Entity net.yunzhanyi.domain.pojo.Anthology
*/
@Mapper
public interface AnthologyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Anthology record);

    int insertSelective(Anthology record);

    Anthology selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Anthology record);

    int updateByPrimaryKey(Anthology record);

    List<Anthology> selectByParentId(int i);

    List<Anthology> selectListByParentId(@Param("parentId") Integer parentId);
}

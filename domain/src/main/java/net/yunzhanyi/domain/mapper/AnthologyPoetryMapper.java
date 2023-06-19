package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.AnthologyPoetry;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bestct
* @description 针对表【anthology_poetry】的数据库操作Mapper
* @createDate 2023-05-28 11:03:21
* @Entity net.yunzhanyi.domain.pojo.AnthologyPoetry
*/

@Mapper
public interface AnthologyPoetryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AnthologyPoetry record);

    int insertSelective(AnthologyPoetry record);

    AnthologyPoetry selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AnthologyPoetry record);

    int updateByPrimaryKey(AnthologyPoetry record);

}

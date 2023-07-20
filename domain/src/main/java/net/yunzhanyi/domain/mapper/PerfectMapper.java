package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Perfect;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bestct
* @description 针对表【perfect】的数据库操作Mapper
* @createDate 2023-07-20 14:04:45
* @Entity net.yunzhanyi.domain.pojo.Perfect
*/
@Mapper
public interface PerfectMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Perfect record);

    int insertSelective(Perfect record);

    Perfect selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Perfect record);

    int updateByPrimaryKey(Perfect record);

}

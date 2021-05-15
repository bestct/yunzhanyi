package net.yunzhanyi.search.mapper;

import net.yunzhanyi.common.model.Writing;
import net.yunzhanyi.common.model.WritingExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TingChang
 */

@Mapper
public interface WritingMapper {

    long countByExample(WritingExample example);

    int deleteByExample(WritingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Writing record);

    int insertSelective(Writing record);

    List<Writing> selectByExampleWithBLOBs(WritingExample example);

    List<Writing> selectByExample(WritingExample example);

    Writing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Writing record, @Param("example") WritingExample example);

    int updateByExampleWithBLOBs(@Param("record") Writing record, @Param("example") WritingExample example);

    int updateByExample(@Param("record") Writing record, @Param("example") WritingExample example);

    int updateByPrimaryKeySelective(Writing record);

    int updateByPrimaryKeyWithBLOBs(Writing record);

    int updateByPrimaryKey(Writing record);
}
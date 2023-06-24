package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Rhyme;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bestct
* @description 针对表【rhyme】的数据库操作Mapper
* @createDate 2023-05-09 09:03:37
* @Entity net.yunzhanyi.domain.pojo.Rhyme
*/
@Mapper
public interface RhymeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Rhyme record);

    int insertSelective(Rhyme record);

    Rhyme selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Rhyme record);

    int updateByPrimaryKey(Rhyme record);

    List<Rhyme> selectByRhymeBookId(Integer rhymeBookId);

    List<Rhyme> selectByHanZi(@Param("hanZi") String hanZi);
}

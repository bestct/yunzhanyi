package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.RhymeBook;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bestct
* @description 针对表【rhyme_book】的数据库操作Mapper
* @createDate 2023-05-09 09:03:37
* @Entity net.yunzhanyi.domain.pojo.RhymeBook
*/

@Mapper
public interface RhymeBookMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RhymeBook record);

    int insertSelective(RhymeBook record);

    RhymeBook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RhymeBook record);

    int updateByPrimaryKey(RhymeBook record);

}

package net.yunzhanyi.admin.mapper;

import net.yunzhanyi.common.model.Author;
import net.yunzhanyi.common.model.AuthorExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author TingChang
 */

@Mapper
public interface AuthorMapper {
    long countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);

    List<Author> selectIdByName(@Param("author") String author,@Param("dynasty") String dynasty);

    List<Author> selectAll();

    List<Author> selectBySearchVal(@Param("searchVal") String searchVal,@Param("dynasty") String dynasty);

    void deleteByAuthorIds(@Param("authorIds") List<Integer> authorIds);
}
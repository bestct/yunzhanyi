package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bestct
* @description 针对表【author】的数据库操作Mapper
* @createDate 2023-05-05 13:52:27
* @Entity net.yunzhanyi.domain.pojo.Author
*/

@Mapper
public interface AuthorMapper {

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
    int insert(Author record);

    /**
     * 插入选择性
     *
     * @param record 记录
     * @return int
     */
    int insertSelective(Author record);

    /**
     * 选择通过主键
     *
     * @param id id
     * @return {@link Author}
     */
    Author selectByPrimaryKey(Long id);

    /**
     * 更新主键选择性
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(Author record);

    /**
     * 更新主键
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(Author record);

    /**
     * 选择作者简单
     *
     * @param offset   抵消
     * @param pageSize 页面大小
     * @return {@link List}<{@link Author}>
     */
    List<Author> selectAuthorSimple(@Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 选择数
     *
     * @return {@link Integer}
     */
    Integer selectCount();

    /**
     * 选择通过关键字
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Author}>
     */
    List<Author> selectByKeyword(@Param("keyword") String keyword);

    String selectAuthorNameById(@Param("authorId") Long authorId);

    List<Author> selectAllAuthor(@Param("dynasty") Integer dynasty);
}

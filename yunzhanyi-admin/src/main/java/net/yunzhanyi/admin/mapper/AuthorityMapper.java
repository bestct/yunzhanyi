package net.yunzhanyi.admin.mapper;

import net.yunzhanyi.common.model.Authority;
import net.yunzhanyi.common.model.AuthorityExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TingChang
 */
@Mapper
public interface AuthorityMapper {
    long countByExample(AuthorityExample example);

    int deleteByExample(AuthorityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Authority record);

    int insertSelective(Authority record);

    List<Authority> selectByExample(AuthorityExample example);

    Authority selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

    List<Authority> selectBySearchVal(String searchVal);

    void deleteByAuthorityIds(@Param("authorityIds") List<Integer> authorityIds);

    List<Authority> selectByAll();

    void deleteRelationshipByAuthorityIds(@Param("authorityIds") List<Integer> authorityIds);

    List<Authority> selectByRid(Integer id);
}
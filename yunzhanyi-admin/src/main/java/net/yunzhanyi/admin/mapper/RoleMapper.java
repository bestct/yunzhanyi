package net.yunzhanyi.admin.mapper;

import net.yunzhanyi.common.model.Role;
import net.yunzhanyi.common.model.RoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TingChang
 */
@Mapper
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectBySearch(String searchVal);

    void deleteByRoleIds(@Param("roleIds") List<Integer> roleId);

    List<Integer> selectByAuthIdByRid(String rid);

    void deleteRelationshipByRid(Integer rid);

    void insertRoleRelationship(@Param("aids") List<Integer> aids,@Param("rid") Integer rid);

    List<Role> selectByAll();

    void deleteAdminRelationshipByRoleIds(@Param("roleIds") List<Integer> roleIds);

    void deleteAuthRelationshipByRoleIds(@Param("roleIds") List<Integer> roleIds);

    List<Role> selectByAid(Integer adminId);
}
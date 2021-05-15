package net.yunzhanyi.admin.mapper;

import net.yunzhanyi.common.model.Admin;
import net.yunzhanyi.common.model.AdminExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author TingChang
 */

@Mapper
public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Admin selectByAdminId(String username);

    List<Admin> selectBySearchVal(String searchVal);

    void deleteByAdminIds(List<Integer> adminIds);

    Admin selectByAid(Integer aid);

    List<Integer> selectByRoleIdByAid(String aid);

    void deleteRelationshipByAid(Integer aid);

    void insertRoleRelationship( @Param("rids") List<Integer> rids, @Param("aid") Integer aid);

    void deleteRelationshipByAdminIds( @Param("adminIds") List<Integer> adminIds);

    void updatePasswordByPrimaryKey(Admin admin);
}
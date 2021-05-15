package net.yunzhanyi.admin.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.dto.AuthorityDto;
import net.yunzhanyi.common.model.Role;

import java.util.List;

/**
 * @author TingChang
 * @name RoleService
 * @date 2021/5/11
 * description:
 */


public interface RoleService {
    PageInfo<Role> getRolePageInfo(Integer pageNum, Integer pageSize, String searchVal);

    void addRole(Role role);

    void editRole(Role role);

    void deleteRole(List<Integer> roleIds);

    AuthorityDto getRoleAuth(String rid);

    void addRoleRelationship(List<Integer> aids, Integer rid);
}

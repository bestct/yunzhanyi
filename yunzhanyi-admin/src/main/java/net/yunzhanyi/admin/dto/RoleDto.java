package net.yunzhanyi.admin.dto;

import net.yunzhanyi.common.model.Role;

import java.util.List;

/**
 * @author TingChang
 * @code RoleDTO
 * @date 2021/5/11
 * description:
 */

public class RoleDto {
    private List<Role> allRole;
    private List<Integer> ids;

    public RoleDto() {
    }

    public RoleDto(List<Role> roles, List<Integer> ids) {
        this.allRole = roles;
        this.ids = ids;
    }

    public List<Role> getAllRole() {
        return allRole;
    }

    public void setAllRole(List<Role> allRole) {
        this.allRole = allRole;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

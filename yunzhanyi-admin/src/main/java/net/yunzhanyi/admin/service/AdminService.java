package net.yunzhanyi.admin.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.dto.RoleDto;
import net.yunzhanyi.common.model.Admin;

import java.util.List;

/**
 * @author TingChang
 * @code AdminService
 * @date 2021/4/26
 * description:
 */

public interface AdminService {

    /**
     * 添加管理员
     * @param admin
     */
    void addAdmin(Admin admin);


    PageInfo<Admin> getAdminPageInfo(Integer pageNum, Integer pageSize, String searchVal);

    void removeAdmin(List<Integer> adminIds);

    Admin getAdminByAid(Integer aid);

    void editAdmin(Admin admin);

    RoleDto getAdminRole(String aid);

    void addAdminRelationship(List<Integer> rids, Integer aid);

    void changePasswordByUserName(String oldPassword, String newPassword, String username);
}

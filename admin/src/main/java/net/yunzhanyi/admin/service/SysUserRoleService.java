package net.yunzhanyi.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import net.yunzhanyi.admin.model.entity.SysUserRole;

import java.util.List;

public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 保存用户角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
     boolean saveUserRoles(Long userId, List<Long> roleIds);
}

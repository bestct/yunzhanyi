package net.yunzhanyi.admin.service.impl;

import net.yunzhanyi.admin.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理用户服务impl
 *
 * @author bestct
 * @date 2023/04/20
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    public AdminUserMapper adminUserMapper;

    @Override
    public AdminUser getUser(Integer userid) {
        return adminUserMapper.selectByPrimaryKey(userid);
    }
}

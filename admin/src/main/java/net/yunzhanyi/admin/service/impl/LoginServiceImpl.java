package net.yunzhanyi.admin.service.impl;

import net.yunzhanyi.admin.service.LoginService;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 登录服务impl
 *
 * @author bestct
 * @date 2023/04/23
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private AdminUserMapper userMapper;

    /**
     * 登录
     *  @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public LoginUser login(String username, String password) {

        AdminUser adminUser = userMapper.selectByUsername(username);
        if (Objects.isNull(adminUser) || !SecurityUtils.matchesPassword(password, adminUser.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserid(adminUser.getUserid().longValue());
        loginUser.setUsername(adminUser.getUsername());
        return loginUser;
    }
}

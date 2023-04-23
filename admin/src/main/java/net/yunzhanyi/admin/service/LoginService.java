package net.yunzhanyi.admin.service;

import net.yunzhanyi.security.model.LoginUser;

/**
 * 登录服务
 *
 * @author bestct
 * @date 2023/04/23
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link LoginUser}
     */
    LoginUser login(String username, String password);

}

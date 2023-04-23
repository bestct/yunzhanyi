package net.yunzhanyi.admin.service;

/**
 * @author bestct
 * @date 2023/4/23
 * description: TODO
 */
public interface LoginService {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     */
    void login(String username, String password);

}

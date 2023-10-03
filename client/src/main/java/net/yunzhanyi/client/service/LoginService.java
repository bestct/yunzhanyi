package net.yunzhanyi.client.service;

import net.yunzhanyi.common.security.model.LoginUser;

/**
 * @author bestct
 * @date 2023/7/14
 * description: TODO
 */
public interface LoginService {
    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @return {@link LoginUser}
     */
    LoginUser login(String account, String password);

    /**
     * 检查手机独特
     *
     * @param phone 电话
     * @return boolean
     */
    boolean checkPhoneUnique(String phone);

    /**
     * 注册
     *
     * @param phone    电话
     * @param password 密码
     */
    void register(String phone, String password);

    LoginUser miniLogin(String principal);
}

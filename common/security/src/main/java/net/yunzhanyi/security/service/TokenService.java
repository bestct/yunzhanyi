package net.yunzhanyi.security.service;

import net.yunzhanyi.security.model.LoginUser;

import java.util.Map;

/**
 * @author bestct
 * @date 2023/4/23
 * description: TODO
 */
public interface TokenService {

    /**
     * 创建令牌
     *
     * @param loginUser 登录用户
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> createToken(LoginUser loginUser);

    /**
     * 获取登录用户
     *
     * @return {@link LoginUser}
     */
    LoginUser getLoginUser();
}

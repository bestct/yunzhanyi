package net.yunzhanyi.common.security.service;

import net.yunzhanyi.common.security.model.LoginUser;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 获取登录用户
     *
     * @param request 请求
     * @return {@link LoginUser}
     */
    LoginUser getLoginUser(HttpServletRequest request);

    /**
     * 获取登录用户
     *
     * @param token 令牌
     * @return {@link LoginUser}
     */
    LoginUser getLoginUser(String token);

    /**
     * 验证令牌
     *
     * @param loginUser 登录用户
     */
    void verifyRefreshToken(LoginUser loginUser);

    /**
     * 删除登录用户令牌
     *
     * @param token 令牌
     */
    void removeLoginUserToken(String token);

    /**
     * 获得令牌密钥
     *
     * @param token 令牌
     * @return {@link String}
     */
    String getTokenKey(String token);
}

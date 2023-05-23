package net.yunzhanyi.security.service.impl;

import cn.hutool.core.lang.UUID;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.core.constants.SecurityConstants;
import net.yunzhanyi.common.core.utils.JwtUtils;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.common.web.utils.ServletUtils;
import net.yunzhanyi.security.model.LoginUser;
import net.yunzhanyi.security.service.TokenService;
import net.yunzhanyi.security.utils.SecurityUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 管理令牌服务impl
 *
 * @author bestct
 * @date 2023/04/27
 */

@Component
public class AdminTokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;

    private final static String ACCESS_TOKEN = CacheConstants.LOGIN_TOKEN_KEY;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private final static Long MILLIS_MINUTE_TEN = CacheConstants.REFRESH_TIME * MILLIS_MINUTE;

    /**
     * 创建令牌
     *
     * @param loginUser 登录用户
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    @Override
    public Map<String, Object> createToken(LoginUser loginUser) {
        String token = UUID.fastUUID().toString();
        loginUser.setToken(token);
        refreshToken(loginUser);
        // Jwt存储信息
        Map<String, Object> claimsMap = new HashMap<String, Object>();
        claimsMap.put(SecurityConstants.USER_KEY, token);
        claimsMap.put(SecurityConstants.DETAILS_USERID, loginUser.getUserid());
        claimsMap.put(SecurityConstants.DETAILS_USERNAME, loginUser.getUsername());

        // 接口返回信息
        Map<String, Object> rspMap = new HashMap<String, Object>();
        rspMap.put("access_token", JwtUtils.createToken(claimsMap));
        rspMap.put("expires_in", CacheConstants.EXPIRATION);
        return rspMap;
    }

    /**
     * 刷新令牌有效期
     *
     * @param loginUser 登录信息
     */
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + CacheConstants.EXPIRATION * MILLIS_MINUTE);
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisService.setCacheObject(userKey, loginUser, CacheConstants.EXPIRATION, TimeUnit.MINUTES);
    }

    private String getTokenKey(String token) {
        return ACCESS_TOKEN + token;
    }
    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    @Override
    public LoginUser getLoginUser()
    {
        return getLoginUser(ServletUtils.getRequest());
    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    @Override
    public LoginUser getLoginUser(HttpServletRequest request)
    {
        // 获取请求携带的令牌
        String token = SecurityUtils.getToken(request);
        return getLoginUser(token);
    }

    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser
     */
    @Override
    public void verifyRefreshToken(LoginUser loginUser) {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN)
        {
            refreshToken(loginUser);
        }
    }

    @Override
    public void removeLoginUserToken(String token) {
        if (StringUtils.isNotEmpty(token))
        {
            String userkey = JwtUtils.getUserKey(token);
            redisService.deleteObject(getTokenKey(userkey));
        }

    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    @Override
    public LoginUser getLoginUser(String token)
    {
        LoginUser user;
        try
        {
            if (StringUtils.isNotEmpty(token))
            {
                String userkey = JwtUtils.getUserKey(token);
                user = redisService.getCacheObject(getTokenKey(userkey));
                return user;
            }
        } catch (Exception ignored)
        {
        }
        return null;
    }

}
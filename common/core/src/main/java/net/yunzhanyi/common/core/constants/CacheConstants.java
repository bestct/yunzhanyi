package net.yunzhanyi.common.core.constants;

/**
 * @author bestct
 * @date 2023/4/23
 * description: TODO
 */
public class CacheConstants {
    /**
     * 缓存有效期，默认720（分钟）
     */
    public final static long EXPIRATION = 720;

    /**
     * 缓存刷新时间，默认60（分钟）
     */
    public final static long REFRESH_TIME = 30;

    public static final String LOGIN_TOKEN_KEY = "login_tokens:";
}

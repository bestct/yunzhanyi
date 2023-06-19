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

    /**
     * 登录令牌密钥
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 复述,指数王朝
     */
    public static final String REDIS_INDEX_DYNASTIES="yunzhanyi:index:dynasties";
    /**
     * 复述,索引部分
     */
    public static final String REDIS_INDEX_PARTS = "yunzhanyi:index:parts";
    /**
     * 复述,指数诗歌
     */
    public static final String REDIS_INDEX_POETRY = "yunzhanyi:index:poetry";
    /**
     * 复述,索引标签
     */
    public static final String REDIS_INDEX_TAGS="yunzhanyi:index:tags";
    /**
     * 复述,指数作者
     */
    public static final String REDIS_INDEX_AUTHORS = "yunzhanyi:index:authors";
    /**
     * 复述,指数热作者
     */
    public static final String REDIS_INDEX_HOT_AUTHORS = "yunzhanyi:index:hotAuthors";
    /**
     * 诗词缓存
     */
    public static final String REDIS_INDEX_POETRIES = "yunzhanyi:index:poetries";
    /**
     * 复述,指数选集
     */
    public static final String REDIS_INDEX_ANTHOLOGY = "yunzhanyi:index:anthology";
    /**
     * 热词
     */
    public static String HOT_WORD_KEY = "yunzhanyi:index:hotWords";

}

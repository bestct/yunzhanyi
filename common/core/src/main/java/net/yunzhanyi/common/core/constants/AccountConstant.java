package net.yunzhanyi.common.core.constants;

/**
 * @author qiuxin
 * @code AccountConstant
 * @date 2022/4/6
 * description：
 */
public class AccountConstant {
    public static final String REGISTER_SUCCESS = "注册成功";
    public static final String PHONE_NOT_UNIQUE = "此手机号已被注册";
    public static final String PHONE_ERROR = "请输入正确的手机号";
    public static final String PASSWORD_ERROR = "密码长度不能小于8";
    public static final String CREATE_ERROR = "创建账号失败";
    public static final String AUTH = "aid";
    public static final String USER = "uid";
    public static final String RTK = "RedisTokenKey";
    public static final String ACCOUNT_TOKEN_RTK = "yunzhanyi:client:accountToken:";
    public static final String VERIFICATION_EXPIRED = "验证已过期";
    public static final String DEFAULT_USER = "默认用户";
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final Integer DISABLED = 0;
    public static final Integer ACTIVE = 1;
    public static final Integer DESTROY = -1;
    public static final String LOGIN_USER = "loginUser";
    public static final String EMAIL_ERROR = "请输入正确的邮箱";
    public static final String EMAIL_NOT_UNIQUE = "此邮箱已被注册";
}

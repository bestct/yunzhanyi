package net.yunzhanyi.client.utils;

import cn.hutool.core.util.ObjectUtil;
import net.yunzhanyi.common.core.constants.AccountConstant;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.web.utils.ServletUtils;

/**
 * @author bestct
 * @date 2023/7/18
 * description:
 */
public class AuthUtils {

    /**
     * 获取用户标识
     *
     * @return {@link Long}
     */
    public static Long getUserid() {
        LoginUser loginUser = getLoginUser();
        if (loginUser == null) {
            return -1L;
        }
        return loginUser.getUserid();
    }

    /**
     * 获得复述,令牌密钥
     *
     * @return {@link String}
     */
    public static String getRedisTokenKey() {
        Object redisTokenKey = ServletUtils.getAttribute(AccountConstant.RTK);
        if (ObjectUtil.isNull(redisTokenKey)) {
            return "";
        }
        return redisTokenKey.toString();
    }

    /**
     * 获取登录用户
     *
     * @return {@link LoginUser}
     */
    public static LoginUser getLoginUser() {
        return (LoginUser) ServletUtils.getAttribute(AccountConstant.LOGIN_USER);
    }
}

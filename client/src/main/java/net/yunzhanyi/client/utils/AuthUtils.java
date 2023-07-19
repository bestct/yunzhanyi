package net.yunzhanyi.client.utils;

import net.yunzhanyi.common.core.constants.AccountConstant;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.web.utils.ServletUtils;

/**
 * @author bestct
 * @date 2023/7/18
 * description:
 */
public class AuthUtils {

    public static Long getUserid() {
        LoginUser loginUser = getLoginUser();
        if (loginUser == null) {
            return -1L;
        }
        return loginUser.getUserid();
    }

    public static LoginUser getLoginUser() {
        return (LoginUser) ServletUtils.getAttribute(AccountConstant.LOGIN_USER);
    }
}

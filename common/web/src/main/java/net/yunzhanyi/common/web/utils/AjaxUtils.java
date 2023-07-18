package net.yunzhanyi.common.web.utils;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.yunzhanyi.common.core.constants.LoginConstant;
import net.yunzhanyi.common.core.constants.TokenConstants;
import net.yunzhanyi.common.core.utils.StringUtils;
import net.yunzhanyi.common.core.vo.AjaxResult;
import org.springframework.http.HttpStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bestct
 * @date 2023/7/15
 * description: TODO
 */
@Slf4j
public class AjaxUtils {
    /**
     * 判断网络请求是否为ajax
     *
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        String contentTypeHeader = request.getHeader("Content-Type");
        String acceptHeader = request.getHeader("Accept");
        String xRequestedWith = request.getHeader("X-Requested-With");
        return (contentTypeHeader != null && contentTypeHeader.contains("application/json"))
                || (acceptHeader != null && acceptHeader.contains("application/json"))
                || "XMLHttpRequest".equalsIgnoreCase(xRequestedWith);
    }
    public static void makeAjaxError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        String msg;
        int code;
        if (ObjectUtil.isEmpty(getAjaxToken(request))){
            msg="未登录,无法访问";
            code= HttpStatus.UNAUTHORIZED.value();
        }else {
            msg="登录已过期";
            code=HttpStatus.FORBIDDEN.value();
        }
        AjaxResult error = AjaxResult.error(code, msg);
        String jsonString = JSON.toJSONString(error);
        response.getWriter().print(jsonString);
    }
    public static String getWebToken(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = null;
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        return checkNull(token);
    }

    private static String getAjaxToken(HttpServletRequest request) {
        return checkNull(request.getHeader(TokenConstants.AUTHENTICATION));
    }

    private static String checkNull(String token) {
        if (StringUtils.isEmpty(token) || LoginConstant.NULL_TOKEN.equals(token) || LoginConstant.UNDEFINED_TOKEN.equals(token)) {
            return null;
        }
        return token;
    }
}

package net.yunzhanyi.admin.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author TingChang
 * @code UnauthorizedEntryPoint
 * @date 2021/4/30
 * description:
 */

public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {
        if (!isAjaxRequest(request)) {
            httpServletResponse.sendRedirect("/login.html");
        }

    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(ajaxFlag);
    }
}

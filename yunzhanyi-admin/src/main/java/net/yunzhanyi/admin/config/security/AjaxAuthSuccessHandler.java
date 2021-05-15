package net.yunzhanyi.admin.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author TingChang
 * @code AjaxAuthSuccessHandler
 * @date 2021/4/30
 * description:
 */

public class AjaxAuthSuccessHandler implements AuthenticationSuccessHandler{


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //返回类型为json
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"status\":\"1\",\"msg\":\"登录成功\"}");
        out.flush();
        out.close();
    }
}

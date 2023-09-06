package net.yunzhanyi.client.interceptor;

import cn.hutool.core.util.ObjectUtil;
import net.yunzhanyi.client.annotation.AccountPublic;
import net.yunzhanyi.client.annotation.CheckLogin;
import net.yunzhanyi.client.annotation.CheckWebLogin;
import net.yunzhanyi.client.task.AsyncFactory;
import net.yunzhanyi.common.core.constants.AccountConstant;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.security.service.TokenService;
import net.yunzhanyi.common.web.manager.AsyncManager;
import net.yunzhanyi.common.web.utils.AjaxUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author qiuxin
 * @code LoginInterceptor
 * @date 2022/3/27
 * description：登录验证拦截器
 */

@Component
public class LoginInterceptor implements AsyncHandlerInterceptor {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        //不是方法 直接放行
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //记录访问量
        AsyncManager.me().execute(AsyncFactory.recordSiteCount(request));
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoginUser loginUser;
        //判断请求类型
        if (AjaxUtils.isAjax(request)) {
            loginUser = tokenService.getLoginUser(request);
            //判断是否需要登录才能通过
            if (method.getAnnotation(CheckLogin.class) == null) {
                //判断是否需要loginUser
                if (method.getAnnotation(AccountPublic.class) != null) {
                    request.setAttribute(AccountConstant.LOGIN_USER, loginUser);
                }
            } else {
                if (ObjectUtil.isEmpty(loginUser)) {
                    //验证不通过返回错误信息
                    AjaxUtils.makeAjaxError(request, response);
                    return false;
                }
            }
        } else {
            loginUser = tokenService.getLoginUser(AjaxUtils.getWebToken(request));
            if (method.getAnnotation(CheckWebLogin.class) != null) {
                if (loginUser == null) {
                    //重定向到登录页面
                    response.sendRedirect("/login?redirect=" + request.getRequestURI());
                    return false;
                }
            }
        }
        if (ObjectUtil.isNotNull(loginUser)){
            request.setAttribute(AccountConstant.LOGIN_USER, loginUser);
            request.setAttribute(AccountConstant.RTK,tokenService.getTokenKey(loginUser.getToken()));
        }
        return true;
    }
}

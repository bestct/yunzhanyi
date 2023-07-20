package net.yunzhanyi.common.web.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.yunzhanyi.common.core.exception.NotLoginException;
import net.yunzhanyi.common.core.exception.NotPermissionException;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.web.utils.AjaxUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理程序
 *
 * @author bestct
 * @date 2023/04/23
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception exception, HttpServletRequest request,HttpServletResponse response) throws IOException {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, exception);
        boolean isAjax = AjaxUtils.isAjax(request);
        if (isAjax) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            AjaxResult error = AjaxResult.error(500, exception.getMessage());
            String string = JSON.toJSONString(error);
            response.getWriter().print(string);
            return null;
        } else {
            if (exception instanceof NullPointerException){
                try {
                    response.sendRedirect("/404");
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ModelAndView mv = new ModelAndView();
            mv.addObject("errorMessage", exception.getMessage());
            mv.setViewName("500");
            return mv;
        }
    }
    /**
     * 处理不允许异常
     *
     * @param e       e
     * @param request 请求
     * @return {@link AjaxResult}
     */
    @ExceptionHandler(NotPermissionException.class)
    public AjaxResult handleNotPermissionException(NotPermissionException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限码校验失败'{}'", requestURI, e.getMessage());
        return AjaxResult.error(HttpStatus.HTTP_FORBIDDEN, "没有访问权限，请联系管理员授权");
    }

    /**
     * 处理未登录异常
     *
     * @param e       e
     * @param request 请求
     * @return {@link AjaxResult}
     */
    @ExceptionHandler(NotLoginException.class)
    public AjaxResult handleNotLoginException(NotLoginException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',登录检验失败'{}'", requestURI, e.getMessage());
        return AjaxResult.error(HttpStatus.HTTP_UNAUTHORIZED, "没有登录凭证，先去登录");
    }

}

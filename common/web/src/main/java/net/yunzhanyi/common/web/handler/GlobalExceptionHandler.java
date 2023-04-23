package net.yunzhanyi.common.web.handler;

import cn.hutool.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import net.yunzhanyi.common.core.AjaxResult;
import net.yunzhanyi.common.core.exception.NotLoginException;
import net.yunzhanyi.common.core.exception.NotPermissionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

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
    public AjaxResult handleException(Exception e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return AjaxResult.error(e.getMessage());
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

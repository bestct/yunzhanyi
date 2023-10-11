package net.yunzhanyi.admin.security.exception;

import net.yunzhanyi.admin.common.result.ResultCode;
import net.yunzhanyi.admin.common.util.ResponseUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Spring Security访问异常处理器
 *
 * @author haoxr
 * @since 2022/10/18
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ResponseUtils.writeErrMsg(response, ResultCode.TOKEN_ACCESS_FORBIDDEN);
    }
}

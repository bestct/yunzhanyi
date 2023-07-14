package net.yunzhanyi.common.security.filter;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.core.utils.StringUtils;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.security.service.TokenService;
import net.yunzhanyi.common.web.utils.BeanUtils;
import net.yunzhanyi.common.web.utils.ServletUtils;
import net.yunzhanyi.common.security.config.IgnoreWhiteProperties;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author bestct
 * @date 2023/4/24
 * description: TODO
 */

public class LoginFilter extends OncePerRequestFilter {

    TokenService tokenService;
    IgnoreWhiteProperties ignoreWhiteProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (tokenService == null) {
            tokenService = BeanUtils.getBean(TokenService.class);
        }
        if (ignoreWhiteProperties == null) {
            ignoreWhiteProperties = BeanUtils.getBean(IgnoreWhiteProperties.class);
        }

        List<String> whites = ignoreWhiteProperties.getWhites();
        String requestURI = request.getRequestURI();
        if (StringUtils.matches(requestURI, whites)) {
            filterChain.doFilter(request, response);
        } else {
            LoginUser loginUser = tokenService.getLoginUser(request);
            if (!Objects.isNull(loginUser)) {
                tokenService.verifyRefreshToken(loginUser);
                filterChain.doFilter(request, response);
            } else {
                int code = HttpStatus.HTTP_UNAUTHORIZED;
                String msg = StringUtils.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
                ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
            }

        }
    }
}

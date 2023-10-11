package net.yunzhanyi.admin.filter;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import net.yunzhanyi.admin.common.constant.SecurityConstants;
import net.yunzhanyi.admin.common.result.ResultCode;
import net.yunzhanyi.admin.common.util.RequestUtils;
import net.yunzhanyi.admin.common.util.ResponseUtils;
import net.yunzhanyi.admin.security.JwtTokenManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT 校验过滤器
 *
 * @author haoxr
 * @since 2022/10/1
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final AntPathRequestMatcher LOGIN_PATH_REQUEST_MATCHER = new AntPathRequestMatcher(SecurityConstants.LOGIN_PATH, "POST");

    private final JwtTokenManager tokenManager;

    public JwtAuthenticationFilter(JwtTokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 登录接口放行是走过滤器链的方式(验证码校验过滤器)，这里拦截到登录接口需要手动放行
        if (LOGIN_PATH_REQUEST_MATCHER.matches(request)) {
            // 手动放行登录接口
            chain.doFilter(request, response);
        }else{
            String jwt = RequestUtils.resolveToken(request);
            if (StrUtil.isNotBlank(jwt) && SecurityContextHolder.getContext().getAuthentication() == null) {
                try {
                    // 解析&验证 JWT
                    Claims claims = this.tokenManager.parseAndValidateToken(jwt);

                    // JWT验证有效获取Authentication存入Security上下文
                    Authentication authentication = this.tokenManager.getAuthentication(claims);
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                    chain.doFilter(request, response);
                }catch (Exception e){
                    ResponseUtils.writeErrMsg(response, ResultCode.TOKEN_INVALID);
                }
            }else{
                ResponseUtils.writeErrMsg(response, ResultCode.TOKEN_INVALID);
            }
        }
    }
}

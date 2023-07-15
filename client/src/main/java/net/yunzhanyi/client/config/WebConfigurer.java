package net.yunzhanyi.client.config;

import net.yunzhanyi.client.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author bestct
 * @date 2022/10/1
 * @type 类
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] strs = {"/api/login/**","/api/register","/css/**","/js/**","/img/**","/error/**","/login","/404","/druid/**"};
        //注册登录拦截器
        registry
                .addInterceptor(loginInterceptor)
                //所有路径都被拦截
                .addPathPatterns("/**")
                .excludePathPatterns(strs);
    }
}

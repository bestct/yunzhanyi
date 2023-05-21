package net.yunzhanyi.admin.config;

import net.yunzhanyi.security.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 过滤器配置
 *
 * @author bestct
 * @date 2023/05/08
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LoginFilter());
        // 设置filter顺序
        bean.setOrder(50);
        bean.addUrlPatterns("/*");
        return bean;
    }
}

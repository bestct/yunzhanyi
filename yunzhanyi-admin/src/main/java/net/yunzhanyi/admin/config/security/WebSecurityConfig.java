package net.yunzhanyi.admin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author TingChang
 * @code WebSecurityConfig
 * @date 2021/4/30
 * description:
 */

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("myUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*开启自定义数据库的登录方式*/
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        /*忽略静态资源*/

        web.ignoring().antMatchers("/element/**","/vue/**","/js/**","/css/**","/image/**","/particles/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .accessDeniedHandler(new SimpleAccessDeniedHandler())
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                .formLogin()                   // 表单登录
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login.html")           //  自定义登录页面URL
                .loginProcessingUrl("/login")       // 处理登录请求的URL
                .successForwardUrl("/index")
                .successHandler(new AjaxAuthSuccessHandler())
                .failureHandler(new AjaxAuthFailureHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html")
                .and()
                .authorizeRequests()                 // 对请求做授权
                .antMatchers("/login","/login.html")
                .permitAll() // 登录页面不需要认证
                .anyRequest() // 任何请求
                .authenticated() // 都需要身份认证
                .and()
                .csrf()
                .disable(); // 暂时将防护跨站请求伪造的功能置为不可用

    }
}

package net.yunzhanyi.admin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 应用程序配置
 *When allowCredentials is true, allowedOrigins cannot contain the special value "*" since that cannot be set on the "Access-Control-Allow-Origin" response header. To allow credentials to a set of origins, list them explicitly or consider using "allowedOriginPatterns" instead.
 * @author bestct
 * @date 2023/04/20
 */
@ComponentScan("net.yunzhanyi")
@Configuration
public class ProjectConfig  {

}

package net.yunzhanyi.common.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bestct
 * @date 2023/7/20
 * description: TODO
 */

@Configuration
@EnableKnife4j
public class Knife4jConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    /**
     * 接口信息
     */
    @Bean
    public OpenAPI apiInfo() {

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("Authorization",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer").bearerFormat("JWT")
                        )
                )

                .info(new Info()
                        .title(swaggerProperties.getTitle())
                        .description(swaggerProperties.getDescription())
                        .contact(new Contact()
                                .email(swaggerProperties.getEmail())
                                .name(swaggerProperties.getName())
                                .url(swaggerProperties.getUrl()))
                        .version(swaggerProperties.getVersion())
                        .license(new License().name("Apache 2.0")
                                .url(swaggerProperties.getUrl()))
                );
    }


    /**
     * 系统接口分组
     */
    @Bean
    public GroupedOpenApi systemApi() {
        String[] paths = {"/**"};
        String[] packagesToScan = {swaggerProperties.getBasePackage()};
        return GroupedOpenApi.builder()
                .group(swaggerProperties.getTitle())
                .packagesToScan(packagesToScan)
                .pathsToMatch(paths)
                .build();
    }

}

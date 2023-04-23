package net.yunzhanyi.common.swagger.config;

import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

/**
 * Swagger配置
 *
 * @author bestct
 * @date 2023/04/22
 */

@Slf4j
@Configuration
public class SwaggerConfig {

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperties swaggerProperties() {
        return new SwaggerProperties();
    }

    /**
     * 根据@Tag 上的排序，写入x-order
     *
     * @return the global open api customizer
     */

    @Autowired
    SwaggerProperties swaggerProperties;

    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags()!=null){
                openApi.getTags().forEach(tag -> {
                    Map<String,Object> map=new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0,100));
                    tag.setExtensions(map);
                });
            }
            if(openApi.getPaths()!=null){
                openApi.addExtension("x-test123","333");
                openApi.getPaths().addExtension("x-abb", RandomUtil.randomInt(1,100));
            }

        };
    }

    @Bean
    public GroupedOpenApi userApi(){
        String[] paths = { "/**" };
        return GroupedOpenApi.builder()
                .group("后台")
                .pathsToMatch(paths)
                .packagesToScan(swaggerProperties.getBasePackage()).build();
    }
    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName(swaggerProperties.getContact().getName());
        contact.setEmail(swaggerProperties.getContact().getEmail());
        return new OpenAPI()
                .info(new Info()
                        .title(swaggerProperties.getTitle())
                        .version(swaggerProperties.getVersion())
                        .contact(contact)
                        .description( swaggerProperties.getDescription())
                        .termsOfService(swaggerProperties.getTermsOfServiceUrl())
                        .license(new License().name(swaggerProperties.getLicense())
                                .url("http://doc.xiaominfo.com"))).externalDocs(new ExternalDocumentation()
                .description(swaggerProperties.getDescription())
                .url(swaggerProperties.getLicenseUrl()))
                .schemaRequirement(HttpHeaders.AUTHORIZATION,this.securityScheme())
                ;
    }

    private SecurityScheme securityScheme() {
        SecurityScheme securityScheme = new SecurityScheme();
        //类型
        securityScheme.setType(SecurityScheme.Type.APIKEY);
        //请求头的name
        securityScheme.setName(HttpHeaders.AUTHORIZATION);
        //token所在未知
        securityScheme.setIn(SecurityScheme.In.HEADER);
        return securityScheme;
    }
}

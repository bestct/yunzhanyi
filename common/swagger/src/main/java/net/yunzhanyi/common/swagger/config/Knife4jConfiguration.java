package net.yunzhanyi.common.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author bestct
 * @date 2023/7/20
 * description: TODO
 */

@Configuration
@EnableKnife4j
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Contact contact = new Contact(swaggerProperties.getName(), swaggerProperties.getUrl(), swaggerProperties.getEmail());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties.getEnabled())
                .apiInfo(new ApiInfoBuilder()
                        .title(swaggerProperties.getTitle())
                        .description(swaggerProperties.getDescription())
                        .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                        .contact(contact)
                        .version(swaggerProperties.getVersion())
                        .build())
                .groupName(swaggerProperties.getTitle())
                //分组名称
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }
}

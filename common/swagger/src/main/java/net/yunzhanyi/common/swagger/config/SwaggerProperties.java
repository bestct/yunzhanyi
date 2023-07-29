package net.yunzhanyi.common.swagger.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bestct
 * @date 2023/4/22
 * description: TODO
 */
@Slf4j
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties implements ApplicationListener<WebServerInitializedEvent> {
    /**
     * 基本包
     */
    private String basePackage = "";
    /**
     * 基本路径
     */
    private List<String> basePath = new ArrayList();
    /**
     * 排除路径
     */
    private List<String> excludePath = new ArrayList();
    /**
     * 标题
     */
    private String title = "";
    /**
     * 描述
     */
    private String description = "";
    /**
     * 版本
     */
    private String version = "";
    /**
     * 许可证
     */
    private String license = "";
    /**
     * 电子邮件
     */
    private String email;
    /**
     * url
     */
    private String url;
    /**
     * 名字
     */
    private String name;
    /**
     * 许可证url
     */
    private String licenseUrl = "";
    /**
     * url服务条款
     */
    private String termsOfServiceUrl = "";
    /**
     * 主机
     */
    private String host = "";
    /**
     * 授权
     */
    private SwaggerProperties.Authorization authorization = new SwaggerProperties.Authorization();

    public SwaggerProperties() {
    }


    public String getBasePackage() {
        return this.basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public List<String> getBasePath() {
        return this.basePath;
    }

    public void setBasePath(List<String> basePath) {
        this.basePath = basePath;
    }

    public List<String> getExcludePath() {
        return this.excludePath;
    }

    public void setExcludePath(List<String> excludePath) {
        this.excludePath = excludePath;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return this.licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public String getTermsOfServiceUrl() {
        return this.termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SwaggerProperties.Authorization getAuthorization() {
        return this.authorization;
    }

    public void setAuthorization(SwaggerProperties.Authorization authorization) {
        this.authorization = authorization;
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        // 打印 swagger 文档地址
        // 获取端口号
        int port = event.getWebServer().getPort();
        // 获取应用名
        String applicationName = event.getApplicationContext().getApplicationName();
        String hostAddress = "";
        try {
            hostAddress = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        log.info("\n-----------------------------------------" +
                "\nswagger 接口文档地址:" + "\n http://" + hostAddress + ":" + port + applicationName + "/doc.html" +
                "\n-----------------------------------------");

    }

    public static class AuthorizationScope {
        private String scope = "";
        private String description = "";

        public AuthorizationScope() {
        }

        public String getScope() {
            return this.scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class Authorization {
        private String name = "";
        private String authRegex = "^.*$";
        private List<SwaggerProperties.AuthorizationScope> authorizationScopeList = new ArrayList();
        private List<String> tokenUrlList = new ArrayList();

        public Authorization() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthRegex() {
            return this.authRegex;
        }

        public void setAuthRegex(String authRegex) {
            this.authRegex = authRegex;
        }

        public List<SwaggerProperties.AuthorizationScope> getAuthorizationScopeList() {
            return this.authorizationScopeList;
        }

        public void setAuthorizationScopeList(List<SwaggerProperties.AuthorizationScope> authorizationScopeList) {
            this.authorizationScopeList = authorizationScopeList;
        }

        public List<String> getTokenUrlList() {
            return this.tokenUrlList;
        }

        public void setTokenUrlList(List<String> tokenUrlList) {
            this.tokenUrlList = tokenUrlList;
        }
    }
}

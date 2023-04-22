package net.yunzhanyi.common.swagger.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bestct
 * @date 2023/4/22
 * description: TODO
 */
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    private Boolean enabled;
    private String basePackage = "";
    private List<String> basePath = new ArrayList();
    private List<String> excludePath = new ArrayList();
    private String title = "";
    private String description = "";
    private String version = "";
    private String license = "";
    private String licenseUrl = "";
    private String termsOfServiceUrl = "";
    private String host = "";
    private SwaggerProperties.Contact contact = new SwaggerProperties.Contact();
    private SwaggerProperties.Authorization authorization = new SwaggerProperties.Authorization();

    public SwaggerProperties() {
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public SwaggerProperties.Contact getContact() {
        return this.contact;
    }

    public void setContact(SwaggerProperties.Contact contact) {
        this.contact = contact;
    }

    public SwaggerProperties.Authorization getAuthorization() {
        return this.authorization;
    }

    public void setAuthorization(SwaggerProperties.Authorization authorization) {
        this.authorization = authorization;
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

    public static class Contact {
        private String name = "";
        private String url = "";
        private String email = "";

        public Contact() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}

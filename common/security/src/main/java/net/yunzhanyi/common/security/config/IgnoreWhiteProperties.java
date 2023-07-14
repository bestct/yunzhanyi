package net.yunzhanyi.common.security.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 白名单属性
 *
 * @author bestct
 * @date 2023/04/24
 */
/*
@Configuration
@ConfigurationProperties(prefix = "security.ignore")
*/
public class IgnoreWhiteProperties {

    /**
     * 放行白名单配置，网关不校验此处的白名单
     */
    private List<String> whites = new ArrayList<>();

    public List<String> getWhites()
    {
        return whites;
    }

    public void setWhites(List<String> whites)
    {
        this.whites = whites;
    }
}

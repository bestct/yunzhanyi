package net.yunzhanyi.common.web.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.yunzhanyi.common.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bestct
 * @date 2022/7/23
 * @type 类
 */
public class AddressUtils {
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    // IP地址查询
    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";

    // 未知地址
    public static final String UNKNOWN = "XX XX";

    public static String getRealAddressByIP(String ip) {
        // 内网不查询
        if (IPUtils.internalIp(ip)) {
            return "内网IP";
        }
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("ip", ip);
            map.put("json", true);
            String rspStr = HttpUtil.get(IP_URL,map);
            if (StringUtils.isEmpty(rspStr)) {
                log.error("获取地理位置异常 {}", ip);
                return UNKNOWN;
            }
            JSONObject obj = JSON.parseObject(rspStr);
            String region = obj.getString("pro");
            String city = obj.getString("city");
            return String.format("%s %s", region, city);
        } catch (Exception e) {
            log.error("获取地理位置异常 {}", ip);
        }
        return UNKNOWN;
    }
}

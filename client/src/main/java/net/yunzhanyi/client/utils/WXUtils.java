package net.yunzhanyi.client.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.yunzhanyi.common.core.constants.WXConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * wxutils
 *
 * @author bestct
 * @date 2023/07/20
 */
public class WXUtils {
    public static String getOpenid(String code) {
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2sessi" +
                "on";
        Map<String, Object> requestUrlParam = new HashMap<>();
        // https://mp.weixin.qq.com/wxopen/devprofile?action=get_profile&token=164113089&lang=zh_CN
        //小程序appId
        requestUrlParam.put("appid", WXConstant.APPID);
        //小程序secret
        requestUrlParam.put("secret", WXConstant.SECRET);
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");

        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpUtil.post(requestUrl, requestUrlParam));
        return jsonObject.getString("openid");
    }

}

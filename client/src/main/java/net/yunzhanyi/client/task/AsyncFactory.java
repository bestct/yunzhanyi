package net.yunzhanyi.client.task;

import lombok.val;
import net.yunzhanyi.client.service.LoginService;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.web.utils.BeanUtils;
import net.yunzhanyi.common.web.utils.IPUtils;
import net.yunzhanyi.domain.mapper.ClientLoginLogMapper;
import net.yunzhanyi.domain.pojo.ClientLoginLog;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author bestct
 * @date 2023/7/14
 * description: TODO
 */
public class AsyncFactory {
    public static TimerTask recordLoginLog(LoginUser loginUser) {
        return new TimerTask() {
            @Override
            public void run() {
                ClientLoginLog clientLoginLog = new ClientLoginLog();
                clientLoginLog.setLoginTime(new Date(loginUser.getLoginTime()));
                clientLoginLog.setAid(loginUser.getUserid());
                clientLoginLog.setIp(loginUser.getIpaddr());
                clientLoginLog.setLoginDevice(loginUser.getBrowser() + "  " + loginUser.getOs());
                clientLoginLog.setIpLocation(loginUser.getLoginLocation());
                BeanUtils.getBean(ClientLoginLogMapper.class).insertSelective(clientLoginLog);
            }
        };
    }

    public static TimerTask recordSiteCount(HttpServletRequest request) {
       return new TimerTask() {
           @Override
           public void run() {
               String ip = IPUtils.getIpAddress(request);
               val bean = BeanUtils.getBean(RedisService.class);
               bean.addHyperLogLog(CacheConstants.REDIS_SITE_IP,ip);
               bean.incr(CacheConstants.REDIS_SITE_PV,1);
               bean.incr(CacheConstants.REDIS_SITE_SUM_PV,1);
           }
       };
    }

    public static TimerTask recordOpenId(Long aid, String code) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginService loginService = BeanUtils.getBean(LoginService.class);
                //loginService.recordOpenId(aid,code);
            }
        };
    }
}

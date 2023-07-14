package net.yunzhanyi.client.task;

import net.yunzhanyi.client.service.LoginService;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.web.utils.BeanUtils;
import net.yunzhanyi.domain.mapper.ClientLoginLogMapper;
import net.yunzhanyi.domain.pojo.ClientLoginLog;

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
    public static TimerTask recordOpenId(Long aid,String code) {
        return new TimerTask() {
            @Override
            public void run() {
                LoginService loginService = BeanUtils.getBean(LoginService.class);
                //loginService.recordOpenId(aid,code);
            }
        };
    }
}

package net.yunzhanyi.client.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import net.yunzhanyi.client.service.LoginService;
import net.yunzhanyi.client.utils.WXUtils;
import net.yunzhanyi.common.core.constants.AccountConstant;
import net.yunzhanyi.common.core.constants.LoginConstant;
import net.yunzhanyi.common.core.utils.StringUtils;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.security.utils.SecurityUtils;
import net.yunzhanyi.common.web.utils.AddressUtils;
import net.yunzhanyi.common.web.utils.IPUtils;
import net.yunzhanyi.common.web.utils.ServletUtils;
import net.yunzhanyi.domain.mapper.ClientAccountMapper;
import net.yunzhanyi.domain.mapper.ClientUserMapper;
import net.yunzhanyi.domain.pojo.ClientAccount;
import net.yunzhanyi.domain.pojo.ClientUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Objects;

/**
 * @author bestct
 * @date 2023/7/14
 * description: TODO
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ClientUserMapper clientUserMapper;

    @Autowired
    private ClientAccountMapper clientAccountMapper;

    /**
     * 登录
     *
     * @param accountNumber 账户
     * @param password      密码
     * @return {@link LoginUser}
     */
    @Override
    public LoginUser login(String accountNumber, String password) {
        //判断是否为空
        if (StringUtils.isEmpty(accountNumber) || StringUtils.isEmpty(password)) {
            throw new RuntimeException(LoginConstant.LOGIN_FAIL);
        }
        //登录账号有两种
        ClientAccount account;
        if (StringUtils.isMobile(accountNumber)) {
            account = clientAccountMapper.selectByPhone(accountNumber);
        } else if (StringUtils.isEmail(accountNumber)) {
            account = clientAccountMapper.selectByEmail(accountNumber);
        } else {
            throw new RuntimeException(LoginConstant.LOGIN_FAIL);
        }

        //判断是否为空
        if (ObjectUtils.isEmpty(account) || ObjectUtils.isEmpty(account.getAid())) {
            throw new RuntimeException(LoginConstant.LOGIN_FAIL);
        }
        if (!Objects.equals(account.getStatus(), AccountConstant.ACTIVE)) {
            throw new RuntimeException(LoginConstant.ACCOUNT_ERROR);
        }
        //比对密码
        if (!SecurityUtils.matchesPassword(password, account.getPassword())) {
            throw new RuntimeException(LoginConstant.LOGIN_FAIL);
        }
        return createClientLoginUser(account.getAid());
    }

    @Override
    public boolean checkPhoneUnique(String phone) {
        ClientAccount account = clientAccountMapper.selectByPhone(phone);
        return ObjectUtils.isEmpty(account) || ObjectUtils.isEmpty(account.getAid());
    }


    @Override
    public void register(String phone, String password) {
        //加密
        String encode = SecurityUtils.encryptPassword(password);
        ClientAccount clientAccount = new ClientAccount();
        clientAccount.setPhone(phone);
        clientAccount.setPassword(encode);
        clientAccount.setCreatedTime(new Date());
        clientAccountMapper.insertSelective(clientAccount);
        createDefaultUser(clientAccount.getAid());
    }

    @Override
    public LoginUser miniLogin(String principal) {
        String openid = WXUtils.getOpenid(principal);
        ClientAccount account = clientAccountMapper.selectByOpenid(openid);
        //判断是否已注册
        if (ObjectUtil.isNull(account)) {
            account = createAccountByOpenid(openid);
        }

        if (!AccountConstant.ACTIVE.equals(account.getStatus())) {
            throw new RuntimeException(LoginConstant.LOGIN_FAIL);
        }
        return createClientLoginUser(account.getAid());
    }

    private ClientAccount createAccountByOpenid(String openid) {
        ClientAccount account = new ClientAccount();
        account.setOpenid(openid);
        account.setStatus(1);
        account.setCreatedTime(new Date());
        clientAccountMapper.insertSelective(account);
        createDefaultUser(account.getAid());
        return account;
    }

    private void createDefaultUser(Long aid) {
        ClientUser user = new ClientUser();
        user.setAid(aid);
        user.setNickName(AccountConstant.DEFAULT_USER + "_" + StringUtils.getUniqueStr());
        user.setBirthday(new Date());
        user.setSignature("这个人很懒，还没设置签名");
        user.setCreatedTime(new Date());
        clientUserMapper.insertSelective(user);
    }

    private LoginUser createClientLoginUser(Long aid) {
        ClientUser clientUser = clientUserMapper.selectByPrimaryKey(aid);
        LoginUser loginUser = new LoginUser();
        loginUser.setUserid(clientUser.getAid());
        loginUser.setUsername(clientUser.getNickName());
        BeanUtils.copyProperties(clientUser, loginUser);
        setUserAgent(loginUser);
        return loginUser;
    }

    private void setUserAgent(LoginUser loginUser) {
        UserAgent parse = UserAgentUtil.parse(ServletUtils.getHeader("User-Agent"));
        String ip = IPUtils.getIpAddress(ServletUtils.getRequest());
        loginUser.setIpaddr(ip);
        loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        loginUser.setBrowser(parse.getBrowser().getName());
        loginUser.setOs(parse.getOs().getName());
    }

}

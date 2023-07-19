package net.yunzhanyi.client.service.impl;

import cn.hutool.core.util.ObjectUtil;
import net.yunzhanyi.client.service.ClientAccountService;
import net.yunzhanyi.common.security.utils.SecurityUtils;
import net.yunzhanyi.domain.mapper.ClientAccountMapper;
import net.yunzhanyi.domain.pojo.ClientAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author bestct
 * @date 2023/7/15
 * description:
 */
@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientAccountMapper clientAccountMapper;

    @Override
    public ClientAccount findAccountByAid(Long userid) {
        return clientAccountMapper.selectByPrimaryKey(userid);
    }

    /**
     * 检查手机唯一
     *
     * @param phone 电话
     * @return boolean
     */
    @Override
    public boolean checkPhoneUnique(String phone) {
        ClientAccount account = clientAccountMapper.selectByPhone(phone);
        return ObjectUtil.isNull(account) || ObjectUtil.isNull(account.getAid());
    }

    /**
     * 绑定手机
     *
     * @param aid   aid
     * @param phone 电话
     */
    @Override
    public void bindPhone(long aid, String phone) {
        ClientAccount account = new ClientAccount();
        account.setAid(aid);
        account.setModifiedTime(new Date());
        account.setPhone(phone);
        clientAccountMapper.updateByPrimaryKeySelective(account);
    }

    /**
     * 查看邮件独特
     *
     * @param email 电子邮件
     * @return boolean
     */
    @Override
    public boolean checkEmailUnique(String email) {
        ClientAccount account = clientAccountMapper.selectByEmail(email);
        return ObjectUtil.isNull(account) || ObjectUtil.isNull(account.getAid());
    }

    /**
     * 结合电子邮件
     *
     * @param aid   援助
     * @param email 电子邮件
     */
    @Override
    public void bindEmail(long aid, String email) {
        ClientAccount account = new ClientAccount();
        account.setAid(aid);
        account.setModifiedTime(new Date());
        account.setEmail(email);
        clientAccountMapper.updateByPrimaryKeySelective(account);
    }

    /**
     * 更改密码
     *
     * @param aid         aid
     * @param newPassword 新密码
     */
    @Override
    public void changePassword(long aid, String newPassword) {
        ClientAccount account = new ClientAccount();
        account.setAid(aid);
        account.setModifiedTime(new Date());
        account.setPassword(SecurityUtils.encryptPassword(newPassword));
        clientAccountMapper.updateByPrimaryKeySelective(account);
    }
}

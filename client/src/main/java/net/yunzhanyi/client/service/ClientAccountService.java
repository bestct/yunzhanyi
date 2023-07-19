package net.yunzhanyi.client.service;

import net.yunzhanyi.domain.pojo.ClientAccount;

/**
 * @author bestct
 * @date 2023/7/15
 * description: TODO
 */
public interface ClientAccountService {
    /**
     * 发现账户援助
     *
     * @param userid 用户标识
     * @return {@link ClientAccount}
     */
    ClientAccount findAccountByAid(Long userid);

    /**
     * 检查手机独特
     *
     * @param phone 电话
     * @return boolean
     */
    boolean checkPhoneUnique(String phone);

    /**
     * 绑定手机
     *
     * @param aid   援助
     * @param phone 电话
     */
    void bindPhone(long aid, String phone);

    /**
     * 查看邮件独特
     *
     * @param email 电子邮件
     * @return boolean
     */
    boolean checkEmailUnique(String email);

    /**
     * 结合电子邮件
     *
     * @param aid   援助
     * @param email 电子邮件
     */
    void bindEmail(long aid, String email);

    /**
     * 更改密码
     *
     * @param aid         援助
     * @param newPassword 新密码
     */
    void changePassword(long aid, String newPassword);
}

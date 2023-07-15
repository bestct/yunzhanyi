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
}

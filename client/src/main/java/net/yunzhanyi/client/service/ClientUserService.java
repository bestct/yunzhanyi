package net.yunzhanyi.client.service;

import net.yunzhanyi.domain.pojo.ClientUser;

/**
 * @author bestct
 * @date 2023/7/15
 * description: TODO
 */
public interface ClientUserService {
    /**
     * 根据得到用户
     *
     * @param userid 用户标识
     * @return {@link ClientUser}
     */
    ClientUser getUserById(Long userid);

    /**
     * 检查尼克名字独特
     *
     * @param clientUser 客户端用户
     * @return boolean
     */
    boolean checkNickNameUnique(ClientUser clientUser);

    /**
     * 保存用户
     *
     * @param clientUser 客户端用户
     */
    void saveUser(ClientUser clientUser);
}

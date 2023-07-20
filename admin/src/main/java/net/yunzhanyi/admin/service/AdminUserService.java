package net.yunzhanyi.admin.service;

/**
 * 管理用户服务
 *
 * @author bestct
 * @date 2023/04/20
 */
public interface AdminUserService {

    /**
     * 获取用户
     *
     * @param userid 用户标识
     * @return {@link AdminUser}
     */
    AdminUser getUser(Integer userid);
}

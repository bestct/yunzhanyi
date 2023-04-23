package net.yunzhanyi.admin;

import net.yunzhanyi.domain.mapper.AdminUserMapper;
import net.yunzhanyi.domain.pojo.AdminUser;
import net.yunzhanyi.security.utils.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author bestct
 * @date 2023/4/23
 * description: TODO
 */
@SpringBootTest
public class AdminApplicationTest {

    @Autowired
    private AdminUserMapper userMapper;

    @Test
    public void changePassword() {
        String password = SecurityUtils.encryptPassword("123456");
        AdminUser adminUser = new AdminUser();
        adminUser.setUserid(1);
        adminUser.setPassword(password);
        userMapper.updateByPrimaryKeySelective(adminUser);
    }
}

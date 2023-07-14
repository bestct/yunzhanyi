package net.yunzhanyi.client;

import net.yunzhanyi.client.service.LoginService;
import net.yunzhanyi.common.redis.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 客户机应用程序测试
 *
 * @author bestct
 * @date 2023/04/20
 */
@SpringBootTest
public class ClientApplicationTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private LoginService loginService;
    @Test
    void loadContext(){
        loginService.register("15660755782","ct123456");
    }
}

package net.yunzhanyi.client;

import com.alibaba.fastjson.JSON;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.domain.pojo.Dynasty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void loadContext(){
        List<Dynasty> cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_DYNASTIES);
        System.out.println(JSON.toJSONString(cacheList));
    }
}

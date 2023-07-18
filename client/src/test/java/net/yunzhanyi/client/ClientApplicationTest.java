package net.yunzhanyi.client;

import net.yunzhanyi.domain.mapper.ClientCollectionMapper;
import net.yunzhanyi.domain.pojo.ClientCollection;
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
    private ClientCollectionMapper collectionMapper;
    @Test
    void loadContext(){
        ClientCollection clientCollection = collectionMapper.selectByResIdAndUid(1L, 4469L, 1);
        System.out.println(clientCollection);
    }
}

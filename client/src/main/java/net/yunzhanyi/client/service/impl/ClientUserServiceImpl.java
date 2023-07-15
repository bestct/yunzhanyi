package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.ClientUserService;
import net.yunzhanyi.domain.mapper.ClientUserMapper;
import net.yunzhanyi.domain.pojo.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bestct
 * @date 2023/7/15
 * description: TODO
 */
@Service
public class ClientUserServiceImpl implements ClientUserService {

    @Autowired
    private ClientUserMapper clientUserMapper;
    @Override
    public ClientUser getUserById(Long userid) {
        ClientUser clientUser = clientUserMapper.selectByPrimaryKey(userid);
        return clientUser;
    }
}

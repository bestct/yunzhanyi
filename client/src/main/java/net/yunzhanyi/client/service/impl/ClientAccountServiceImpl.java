package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.ClientAccountService;
import net.yunzhanyi.domain.mapper.ClientAccountMapper;
import net.yunzhanyi.domain.pojo.ClientAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bestct
 * @date 2023/7/15
 * description: TODO
 */
@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    @Autowired
    private ClientAccountMapper clientAccountMapper;

    @Override
    public ClientAccount findAccountByAid(Long userid) {
        return clientAccountMapper.selectByPrimaryKey(userid);
    }
}

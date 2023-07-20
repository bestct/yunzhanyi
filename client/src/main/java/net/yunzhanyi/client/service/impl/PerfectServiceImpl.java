package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.PerfectService;
import net.yunzhanyi.client.utils.AuthUtils;
import net.yunzhanyi.domain.mapper.PerfectMapper;
import net.yunzhanyi.domain.pojo.Perfect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author bestct
 * @date 2023/7/20
 * description: TODO
 */
@Service
public class PerfectServiceImpl implements PerfectService {

    @Autowired
    private PerfectMapper perfectMapper;

    @Override
    public void createPerfect(Perfect perfect) {
            long aid = AuthUtils.getUserid();
            perfect.setAid(aid);
            perfect.setCreateTime(new Date());
            perfectMapper.insertSelective(perfect);
    }
}

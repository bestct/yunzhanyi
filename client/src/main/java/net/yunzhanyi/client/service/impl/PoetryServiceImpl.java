package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.domain.mapper.PoetryMapper;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */
@Service
public class PoetryServiceImpl implements PoetryService {
    @Autowired
    private PoetryMapper poetryMapper;

    @Override
    public Poetry getPoetryByRandom() {
        Integer count = poetryMapper.selectCount();
        Random rand = new Random();
        int offset = rand.nextInt(count ) + 1;
        return poetryMapper.selectRandomPoetry(offset);
    }

}

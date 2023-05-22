package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.domain.mapper.DynastyMapper;
import net.yunzhanyi.domain.mapper.PoetryMapper;
import net.yunzhanyi.domain.pojo.Dynasty;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Autowired
    private DynastyMapper dynastyMapper;

    /**
     * 被随机诗歌
     *
     * @return {@link Poetry}
     */
    @Override
    public Poetry getPoetryByRandom() {
        Integer count = poetryMapper.selectCount();
        Random rand = new Random();
        int offset = rand.nextInt(count ) + 1;
        return poetryMapper.selectRandomPoetry(offset);
    }

    /**
     * 随机搜索诗歌
     *
     * @param size 大小
     * @return {@link List}<{@link Poetry}>
     */
    @Override
    public List<Poetry> searchPoetryRandom(int size) {
        Integer count = poetryMapper.selectCount();
        Random rand = new Random();
        int pageNum = rand.nextInt(count / size) + 1;
        int offset = (pageNum - 1) * size;
        System.out.println("offset = " + offset);
        List<Poetry> poetries = poetryMapper.selectPoetrySimple(offset, size);
        System.out.println(poetries);
        return poetries;
    }

    /**
     * init王朝
     *
     * @return {@link List}<{@link Dynasty}>
     */
    @Override
    public List<Dynasty> initDynasty() {
        List<Dynasty> dynasties = dynastyMapper.selectInit();
        return dynasties;
    }

}

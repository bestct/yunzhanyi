package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.PartService;
import net.yunzhanyi.domain.mapper.PartMapper;
import net.yunzhanyi.domain.pojo.Part;
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
public class PartServiceImpl implements PartService {
    @Autowired
    private PartMapper partMapper;
    @Override
    public List<Part> searchPartRandom(int randomSize) {

        long[] ints = new long[randomSize];
        Random rand = new Random();
        int r;
        for (int i = 0; i < randomSize; i++) {
            r = rand.nextInt(6734) + 1;
            ints[i] = r;
        }
        return partMapper.selectByPrimaryKeys(ints);
    }
}

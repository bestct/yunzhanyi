package net.yunzhanyi.client.service;

import net.yunzhanyi.domain.mapper.TagMapper;
import net.yunzhanyi.domain.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/22
 * description: TODO
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> initTag() {
        return tagMapper.selectInit();
    }
}

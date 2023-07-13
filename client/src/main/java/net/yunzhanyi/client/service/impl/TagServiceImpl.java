package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.TagService;
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

    @Override
    public List<Tag> checkTagId(Integer tagId, List<Tag> tagVos) {
        for (Tag tag : tagVos) {
            if (tagId.equals(tag.getTagId())) {
                return tagVos;
            }
        }
        Tag tag = tagMapper.selectByPrimaryKey(tagId);
        tagVos.add(0, tag);
        return tagVos;
    }
}

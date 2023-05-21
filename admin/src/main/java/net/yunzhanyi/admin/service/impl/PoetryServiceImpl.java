package net.yunzhanyi.admin.service.impl;

import net.yunzhanyi.admin.service.PoetryService;
import net.yunzhanyi.domain.mapper.DynastyMapper;
import net.yunzhanyi.domain.mapper.PoetryDetailMapper;
import net.yunzhanyi.domain.mapper.PoetryMapper;
import net.yunzhanyi.domain.pojo.Dynasty;
import net.yunzhanyi.domain.pojo.Poetry;
import net.yunzhanyi.domain.pojo.PoetryDetail;
import net.yunzhanyi.domain.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/5
 * description: TODO
 */
@Service
public class PoetryServiceImpl implements PoetryService {

    @Autowired
    private PoetryMapper poetryMapper;

    @Autowired
    private DynastyMapper dynastyMapper;

    @Autowired
    private PoetryDetailMapper poetryDetailMapper;

    /**
     * 得到列表
     *
     * @param poetry 诗歌
     * @return {@link List}<{@link Poetry}>
     */
    @Override
    public List<Poetry> getList(Poetry poetry) {
        List<Poetry> poetries = poetryMapper.selectList(poetry);
        for (Poetry p : poetries) {
            List<PoetryDetail> poetryDetails = poetryDetailMapper.selectByPoetryId(p.getPoetryId());
            p.setPoetryDetails(poetryDetails);
        }
        return poetries;
    }

    @Override
    public List<Tag> initTag() {
        return null;
    }

    @Override
    public List<Dynasty> initDynasty() {
        return dynastyMapper.selectAll();
    }
}

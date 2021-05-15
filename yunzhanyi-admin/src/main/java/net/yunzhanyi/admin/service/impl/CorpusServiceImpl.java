package net.yunzhanyi.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.mapper.CorpusMapper;
import net.yunzhanyi.admin.service.CorpusService;
import net.yunzhanyi.common.model.Corpus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TingChang
 * @code CorpusServiceImpl
 * @date 2021/4/30
 * description:
 */
@Service
public class CorpusServiceImpl implements CorpusService {

    @Autowired
    private CorpusMapper corpusMapper;


    @Override
    public PageInfo<Corpus> loadCorpusPageInfo(Integer pageNum, Integer pageSize, String searchVal) {
        PageHelper.startPage(pageNum,pageSize);
        List<Corpus> corpusList=corpusMapper.selectBySearchVal(searchVal);
        return new PageInfo<>(corpusList);
    }

    @Override
    public void addCorpus(Corpus corpus) {

    }

    @Override
    public void editCorpus(Corpus corpus) {

    }

    @Override
    public void removeCorpus(List<Integer> corpusIds) {

    }

}

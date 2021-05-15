package net.yunzhanyi.admin.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.common.model.Corpus;

import java.util.List;

/**
 * @author TingChang
 * @code CorpusService
 * @date 2021/4/30
 * description:
 */

public interface CorpusService {
    PageInfo<Corpus> loadCorpusPageInfo(Integer pageNum, Integer pageSize, String searchVal);


    void addCorpus(Corpus corpus);

    void editCorpus(Corpus corpus);

    void removeCorpus(List<Integer> corpusIds);

}

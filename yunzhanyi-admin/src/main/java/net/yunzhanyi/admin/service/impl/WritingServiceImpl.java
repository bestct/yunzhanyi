package net.yunzhanyi.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.exception.WritingAddException;
import net.yunzhanyi.admin.mapper.AuthorMapper;
import net.yunzhanyi.admin.mapper.CorpusMapper;
import net.yunzhanyi.admin.mapper.WritingMapper;
import net.yunzhanyi.admin.service.WritingService;
import net.yunzhanyi.common.model.Author;
import net.yunzhanyi.common.model.Corpus;
import net.yunzhanyi.common.model.Writing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TingChang
 * @code WritingServiceImpl
 * @date 2021/4/30
 * description:
 */
@Service
public class WritingServiceImpl implements WritingService {

    @Autowired
    private CorpusMapper corpusMapper;

    @Autowired
    private AuthorMapper authorMapper;
    @Autowired
    private WritingMapper writingMapper;


    @Override
    public PageInfo<Writing> loadWritingPageInfo(Integer pageNum, Integer pageSize, String searchVal, String type, String dynasty) {
        PageHelper.startPage(pageNum, pageSize);
        List<Writing> writings = writingMapper.selectBySearch(searchVal, type,dynasty);
        return new PageInfo<>(writings);
    }

    @Override
    public void addWriting(Writing writing) {
        List<Author> authors = authorMapper.selectIdByName(writing.getAuthor(), writing.getDynasty());
        if (authors.size()==0){
            throw new WritingAddException("没有此作品的作者,请去作者管理添加");
        }else {
            writing.setAuthorId(authors.get(0).getId());
        }
        if ("".equals(writing.getCorpus())) {
            writing.setCorpusId(0);
        } else {
            List<Corpus> corpuses = corpusMapper.selectIdByName(writing.getCorpus(), writing.getDynasty());
            if (corpuses.size() == 0) {
               throw  new WritingAddException("没有此作品的文集,请去文集管理添加");

            }else {
                writing.setCorpusId(corpuses.get(0).getId());
            }
        }
        writingMapper.insertSelective(writing);
    }

    @Override
    public Writing getWritingOne(Integer id) {
        Writing writing = writingMapper.selectByPrimaryKey(id);
        return writing;
    }

    @Override
    public void remove(List<Integer> writingIds) {
            writingMapper.deleteByWritingIds(writingIds);
    }

    @Override
    public void changeWriting(Writing writing) {
        writingMapper.updateByPrimaryKeySelective(writing);
    }

    @Override
    public List<Integer> getWritingsById(Integer id) {
        List<Integer> wids=writingMapper.selectWritingsByPrimaryKey(id);
        return wids;
    }
}

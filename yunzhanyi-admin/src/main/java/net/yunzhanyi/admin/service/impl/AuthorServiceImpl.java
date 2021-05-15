package net.yunzhanyi.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.mapper.AuthorMapper;
import net.yunzhanyi.admin.service.AuthorService;
import net.yunzhanyi.common.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TingChang
 * @code AuthorServiceImpl
 * @date 2021/4/30
 * description:
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorMapper authorMapper;


    @Override
    public PageInfo<Author> loadAuthorPageInfo(Integer pageNum, Integer pageSize, String searchVal, String dynasty) {
        PageHelper.startPage(pageNum,pageSize);
        List<Author>authors=authorMapper.selectBySearchVal(searchVal,dynasty);
        return new PageInfo<>(authors);
    }

    @Override
    public void addAuthor(Author author) {
        authorMapper.insertSelective(author);
    }

    @Override
    public void editAuthor(Author author) {
        authorMapper.updateByPrimaryKeySelective(author);
    }

    @Override
    public void removeAuthor(List<Integer> authorIds) {
        authorMapper.deleteByAuthorIds(authorIds);
    }
}

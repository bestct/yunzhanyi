package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.service.AuthorService;
import net.yunzhanyi.domain.mapper.AuthorMapper;
import net.yunzhanyi.domain.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author bestct
 * @date 2023/5/22
 * description: TODO
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<Author> searchAuthorRandom(int pageSize) {
        Integer count = authorMapper.selectCount();
        Random rand = new Random();
        int pageNum = rand.nextInt(count / pageSize) + 1;
        int offset = (pageNum - 1) * pageSize;
        List<Author> authors = authorMapper.selectAuthorSimple(offset, pageSize);
        return authors;
    }

    @Override
    public List<Author> searchAuthor(String keyword) {

        List<Author> authors = authorMapper.selectByKeyword(keyword);
        return authors;
    }

}

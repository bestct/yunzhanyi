package net.yunzhanyi.search;

import net.yunzhanyi.common.model.*;
import net.yunzhanyi.search.mapper.AuthorMapper;
import net.yunzhanyi.search.mapper.CorpusMapper;
import net.yunzhanyi.search.mapper.WritingMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class SearchApplicationTest {

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private CorpusMapper corpusMapper;

    @Autowired
    private WritingMapper writingMapper;
    @Test
    public void loading(){
        List<Author> authors = authorMapper.selectByExample(new AuthorExample());
        for (Author author:authors){
            System.out.println(author);
        }
        List<Corpus> corpuses = corpusMapper.selectByExample(new CorpusExample());
        for (Corpus corpus :corpuses){
            System.out.println(corpus);
        }
        List<Writing> writings = writingMapper.selectByExample(new WritingExample());
        for (Writing writing:writings){
            System.out.println(writing);
        }
    }
}
package net.yunzhanyi.admin;


import au.com.bytecode.opencsv.CSVReader;
import net.yunzhanyi.admin.mapper.AuthorMapper;
import net.yunzhanyi.admin.mapper.CorpusMapper;
import net.yunzhanyi.admin.mapper.WritingMapper;
import net.yunzhanyi.admin.service.AdminService;
import net.yunzhanyi.common.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TingChang
 * @code AdminApplicationTests
 * @date 2021/4/26
 * description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class AdminApplicationTests {

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private CorpusMapper corpusMapper;

    @Autowired
    private WritingMapper writingMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void loading() {
        List<Author> authors = authorMapper.selectByExample(new AuthorExample());
        for (Author author : authors) {
            System.out.println(author);
        }
        List<Corpus> corpuses = corpusMapper.selectByExample(new CorpusExample());
        for (Corpus corpus : corpuses) {
            System.out.println(corpus);
        }
        List<Writing> writings = writingMapper.selectByExample(new WritingExample());
        for (Writing writing : writings) {
            System.out.println(writing);
        }
    }

    @Test
    public void adminTest() {

    }

    @Test
    public void dataChange() {
        List<Author> authors=authorMapper.selectAll();
        for (Author author:authors){
            writingMapper.updateByAuthor(author);
        }
    }

    /**
     * 读取CSV文件
     */
    @Test
    public void readeCsv() {
        try {

            CSVReader csvReader = new CSVReader(new FileReader("D:\\Download\\Poetry-master\\当代.csv"));
            String[] strs = csvReader.readNext();
            if (strs != null && strs.length > 0) {
                for (String str : strs)
                    if (null != str && !str.equals(""))
                        System.out.print(str + " , ");
                System.out.println("\n---------------");
            }
            List<String[]> list = csvReader.readAll();
            List<Writing> writings = new ArrayList<>();
            for (String[] ss : list) {
                try {
                    Writing writing = new Writing();
                    writing.setTitle(ss[0]);
                    writing.setDynasty(ss[1]);
                    writing.setAuthor(ss[2]);
                    writing.setContent(ss[3]);
                    writings.add(writing);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (Writing writing : writings) {
                writingMapper.insertSelective(writing);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void insertTest() {
        for (int i = 0; i < 50; i++) {
            Writing writing = new Writing();
            writing.setTitle("诗词" + i);
            writingMapper.insertSelective(writing);
        }
    }

}


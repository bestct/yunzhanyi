package net.yunzhanyi.admin.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.common.model.Author;

import java.util.List;

/**
 * @author TingChang
 * @name AuthorSevice
 * @date 2021/4/30
 * description:
 */

public interface AuthorService {
    PageInfo<Author> loadAuthorPageInfo(Integer pageNum, Integer pageSize, String searchVal,String dynasty);

    void addAuthor(Author author);

    void editAuthor(Author author);

    void removeAuthor(List<Integer> authorIds);
}

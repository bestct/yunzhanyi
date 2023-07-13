package net.yunzhanyi.client.service;

import net.yunzhanyi.client.domain.vo.AuthorVo;
import net.yunzhanyi.domain.pojo.Author;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/22
 * description: TODO
 */
public interface AuthorService {
    /**
     * 作者随机搜索
     *
     * @param i 我
     * @return {@link List}<{@link Author}>
     */
    List<Author> searchAuthorRandom(int i);


    /**
     * 搜索作者
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Author}>
     */
    List<Author> searchAuthor(String keyword);

    AuthorVo searchWebAuthorById(Long authorId);

    String searchAuthorNameById(Long authorId);

    List<Author> selectAllAuthor(Integer dynasty);
}

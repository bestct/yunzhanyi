package net.yunzhanyi.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.client.domain.vo.AuthorVo;
import net.yunzhanyi.client.service.AuthorService;
import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.common.core.vo.PageVo;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author bestct
 * @date 2022/9/30
 * @type 类
 */
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PoetryService poetryService;

    @GetMapping("/author/{authorId}")
    public String authorDetail(@PathVariable Long authorId, Model model) {
        AuthorVo authorVo = authorService.searchWebAuthorById(authorId);
        model.addAttribute("author", authorVo);
        return "author-detail";
    }


    @GetMapping("/author/poetry/{authorId}")
    public String authorPoetry(@PathVariable Long authorId,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                               Model model) {
        String authorName = authorService.searchAuthorNameById(authorId);
        model.addAttribute("authorName",authorName);
        model.addAttribute("authorId",authorId);
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> poetryList = poetryService.getPoetryByAuthorId(authorId);
        PageVo pageVo = poetryService.copyPageInfo(new PageInfo<>(poetryList));
        model.addAttribute("dataInfo", pageVo);
        return "author-poetry";
    }
}

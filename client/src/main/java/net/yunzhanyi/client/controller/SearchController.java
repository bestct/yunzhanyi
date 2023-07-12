package net.yunzhanyi.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.client.service.AuthorService;
import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.common.core.constants.SearchConstants;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.core.vo.PageVo;
import net.yunzhanyi.common.redis.service.HotWordsService;
import net.yunzhanyi.domain.pojo.Author;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bestct
 * @date 2023/5/24
 * description: TODO
 */
@Controller
public class SearchController {

    /**
     * 诗歌服务
     */
    @Autowired
    private PoetryService poetryService;

    /**
     * 作者服务
     */
    @Autowired
    private AuthorService authorService;

    /**
     * 热词服务
     */
    @Autowired
    private HotWordsService hotWordsService;

    @GetMapping("/api/search")
    @ResponseBody
    public AjaxResult search(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "searchType", defaultValue = "poetry") String searchType,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        if (SearchConstants.POETRY.equals(searchType)) {
            List<Poetry> poetryList = poetryService.searchPoetry(keyword);
            PageVo pageVo = poetryService.copyPageInfo(new PageInfo<>(poetryList));
            return AjaxResult.successWithoutMsg(pageVo);
        } else if (SearchConstants.AUTHOR.equals(searchType)){
            List<Author> authorInfo = authorService.searchAuthor(keyword);
            return AjaxResult.successWithoutMsg(new PageInfo<>(authorInfo != null ? authorInfo : new ArrayList<>()));
        }
        return AjaxResult.success();
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "searchType", defaultValue = "poetry") String searchType,
            @RequestParam(value = "hotWord", defaultValue = "false") boolean hotWord,
            Model model) {
        if (hotWord) {
            hotWordsService.addHotWord(keyword, 2);
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchType", searchType);
        return "search";
    }
}

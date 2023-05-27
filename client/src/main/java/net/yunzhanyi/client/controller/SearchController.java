package net.yunzhanyi.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.client.service.AuthorService;
import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.common.core.constants.SearchConstants;
import net.yunzhanyi.common.core.utils.StringUtils;
import net.yunzhanyi.common.core.vo.PageVo;
import net.yunzhanyi.common.redis.service.HotWordsService;
import net.yunzhanyi.domain.pojo.Author;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/search")
    public String search(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "searchType", defaultValue = "poetry") String searchType,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "hotWord", defaultValue = "false") boolean hotWord,
            Model model) {

        PageHelper.startPage(pageNum, pageSize);
        boolean contain = false;
        if (SearchConstants.POETRY.equals(searchType)) {
            List<Poetry> poetryList = poetryService.searchPoetry(keyword);
            PageVo pageVo = poetryService.copyPageInfo(new PageInfo<>(poetryList));
            if (hotWord && StringUtils.isNotEmpty(keyword) && poetryList.size() != 0) {
                contain = true;
            }
            model.addAttribute("dataInfo", pageVo);

        } else if (SearchConstants.AUTHOR.equals(searchType)) {
            List<Author> authorInfo = authorService.searchAuthor(keyword);
            if (hotWord && StringUtils.isNotEmpty(keyword) && authorInfo != null && authorInfo.size() != 0) {
                contain = true;
            }
            model.addAttribute("dataInfo",
                    new PageInfo<>(authorInfo != null ? authorInfo : new ArrayList<>()));
        } else {
            return "redirect:/search?keyword=" + keyword + "&pageNum=" + pageNum + "&pageSize=" + pageSize;
        }

        if (hotWord && contain) {
            hotWordsService.addHotWord(keyword, 2);
        }
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchType", searchType);
        model.addAttribute("pageNum", pageNum);
        model.addAttribute("pageSize", pageSize);

        return "search";
    }
}

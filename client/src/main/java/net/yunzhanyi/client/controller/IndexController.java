package net.yunzhanyi.client.controller;

import com.github.pagehelper.PageHelper;
import net.yunzhanyi.client.service.IndexService;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.domain.pojo.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */

@Controller
public class IndexController {


    @Autowired
    private IndexService indexService;

    @GetMapping({"/index", "/"})
    public String index(Model model) {
        Map<String, Object> map = indexService.index();
        model.addAllAttributes(map);
        return "index";
    }

    @GetMapping("/index/poetry")
    public String indexPoetry(
            @RequestParam(value = "dynasty", defaultValue = "0") Integer dynasty,
            @RequestParam(value = "tag", defaultValue = "0") Integer tagId,
            Model model) {
        model.addAttribute("dynasty", dynasty);
        model.addAttribute("tag", dynasty);
        return "poetry-index";
    }

    @GetMapping("/index/author")
    public String indexAuthor(
            @RequestParam(value = "dynasty", defaultValue = "0") Integer dynasty,
            Model model) {
        model.addAttribute("dynasty", dynasty);
        return "author-index";
    }

    @GetMapping("/api/index/author")
    @ResponseBody
    public AjaxResult<List<Author>> indexAuthor(
            @RequestParam(value = "dynasty", defaultValue = "0") Integer dynasty,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Author> authors = indexService.indexApiAuthor(dynasty);
        return AjaxResult.successWithoutMsg(authors);
    }

    @GetMapping("/show")
    public String about() {
        return "about";
    }
}

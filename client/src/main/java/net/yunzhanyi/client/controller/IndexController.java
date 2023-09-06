package net.yunzhanyi.client.controller;

import com.github.pagehelper.PageHelper;
import lombok.val;
import net.yunzhanyi.client.service.IndexService;
import net.yunzhanyi.client.service.SiteCountService;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.domain.domain.SiteCount;
import net.yunzhanyi.domain.pojo.Author;
import net.yunzhanyi.domain.pojo.Poetry;
import net.yunzhanyi.domain.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 指数控制器
 *
 * @author bestct
 * @date 2023/07/13
 */

@Controller
public class IndexController {


    @Autowired
    private IndexService indexService;

    @Autowired
    private SiteCountService siteCountService;

    @GetMapping({"/index", "/"})
    public String index(Model model) {
        Map<String, Object> map = indexService.index();
        model.addAllAttributes(map);
        return "index";
    }

    @GetMapping("/api/index")
    @ResponseBody
    public AjaxResult<Map<String, Object>> index() {
        Map<String, Object> indexMap = indexService.indexApi();
        return AjaxResult.successWithoutMsg(indexMap);
    }

    @GetMapping("/index/poetry")
    public String indexPoetry(
            @RequestParam(value = "dynasty", defaultValue = "0") Integer dynasty,
            @RequestParam(value = "tag", defaultValue = "0") Integer tagId,
            Model model) {
        model.addAttribute("dynasty", dynasty);
        model.addAttribute("tag", tagId);
        return "poetry-index";
    }

    @GetMapping("/api/tag/{tagId}")
    @ResponseBody
    public AjaxResult<List<Tag>> getTagList(@PathVariable Integer tagId) {
        List<Tag> tags = indexService.getTagList(tagId);
        return AjaxResult.successWithoutMsg(tags);
    }


    @GetMapping("/api/index/pv")
    @ResponseBody
    public AjaxResult<SiteCount> getSiteCount(){
        val siteCount = siteCountService.getSiteCount();
        return AjaxResult.successWithoutMsg(siteCount);
    }

    @GetMapping("/api/index/poetry")
    @ResponseBody
    public AjaxResult<List<Poetry>> indexPoetry(
            @RequestParam(value = "dynasty", defaultValue = "0") Integer dynasty,
            @RequestParam(value = "tag", defaultValue = "0") Integer tagId,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Poetry> poetryList = indexService.indexApiPoetry(dynasty, tagId);
        return AjaxResult.successWithoutMsg(poetryList);
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
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/advise")
    public String advise() {
        return "advise";
    }
}

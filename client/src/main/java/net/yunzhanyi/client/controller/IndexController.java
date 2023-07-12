package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            Model model) {

        Map<String, Object> map = indexService.poetryIndex(dynasty, tagId, pageNum, pageSize);
        model.addAllAttributes(map);

        return "poetry-index";
    }

    @GetMapping("/index/author")
    public String indexAuthor(
            @RequestParam(value = "dynasty", defaultValue = "0") Integer dynasty,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            Model model) {
        Map<String, Object> map = indexService.authorIndex(dynasty,pageNum, pageSize);
        model.addAllAttributes(map);
        /*PageInfo<Author> authorPageInfo = poetryService.indexAuthor(dynasty, pageNum, pageSize);
        model.addAttribute("dataInfo", authorPageInfo);
        List<Dynasty> dynasties = redisService.getCacheList(IndexConstant.REDIS_INDEX_DYNASTIES);
        model.addAttribute("dynasties", dynasties);
        model.addAttribute("indexDynasty", dynasty);*/
        return "author-index";
    }

    @GetMapping("/show")
    public String about() {
        return "about";
    }
}

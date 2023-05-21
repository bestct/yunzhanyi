package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.service.PartService;
import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.domain.pojo.Part;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */

@Controller
public class IndexController {
    @Autowired
    private RedisService redisService;

    @Autowired
    private PoetryService poetryService;
    @Autowired
    private PartService partService;
    @PostConstruct
    private void init() {
        List<Object> cacheList;
        cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_PARTS);
        if (cacheList == null || cacheList.size() == 0) {
            List<Part> parts = partService.searchPartRandom(5);
            redisService.setCacheList(CacheConstants.REDIS_INDEX_PARTS, parts);
        }

        Object cacheObject = redisService.getCacheObject(CacheConstants.REDIS_INDEX_POETRY);
        if (cacheObject == null) {
            Poetry poetry = poetryService.getPoetryByRandom();
            redisService.setCacheObject(CacheConstants.REDIS_INDEX_POETRY, poetry);
        }
    }
    @GetMapping({"/index", "/"})
    public String index(Model model) {
        List<Part> partList = redisService.getCacheList(CacheConstants.REDIS_INDEX_PARTS);
        Poetry poetry = redisService.getCacheObject(CacheConstants.REDIS_INDEX_POETRY);
        model.addAttribute("indexPoetry", poetry);
        model.addAttribute("partList", partList);
        return "index";
    }
}

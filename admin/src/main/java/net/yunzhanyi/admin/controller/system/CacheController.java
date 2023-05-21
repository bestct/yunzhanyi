package net.yunzhanyi.admin.controller.system;

import lombok.extern.slf4j.Slf4j;
import net.yunzhanyi.admin.service.PoetryService;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.domain.pojo.Dynasty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 缓存控制器
 *
 * @author bestct
 * @date 2023/05/06
 */

@Slf4j
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private PoetryService poetryService;

    @PostConstruct
    private void init() {
        List<Object> cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_DYNASTIES);
        if (cacheList == null || cacheList.size() == 0) {
            List<Dynasty> dynasties = poetryService.initDynasty();
            log.info("已存入缓存"+dynasties);
            dynasties.add(0, new Dynasty(0, "全部"));
            redisService.setCacheList(CacheConstants.REDIS_INDEX_DYNASTIES, dynasties);
        }
    }

    @GetMapping("/dynasty")
    public AjaxResult<List<Dynasty>> getDynasty(){
        List<Dynasty> cacheList = redisService.getCacheList(CacheConstants.REDIS_INDEX_DYNASTIES);
        System.out.println(cacheList);
        return AjaxResult.successWithoutMsg(cacheList);
    }
}

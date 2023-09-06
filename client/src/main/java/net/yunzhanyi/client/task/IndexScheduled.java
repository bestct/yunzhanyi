package net.yunzhanyi.client.task;

import net.yunzhanyi.client.service.*;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.redis.service.HotWordsService;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.domain.pojo.Author;
import net.yunzhanyi.domain.pojo.Part;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author bestct
 * @date 2022/10/5
 * @type 类
 */
@Configuration
@Component
@EnableScheduling
public class IndexScheduled {

    @Autowired
    private RedisService redisService;

    @Autowired
    private PoetryService poetryService;

    @Autowired
    private PartService partService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private HotWordsService hotWordsService;

    @Autowired
    private SiteCountService siteCountService;
    /**
     * 每天0点更新
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateIndex() {
        redisService.deleteObject(CacheConstants.REDIS_INDEX_PARTS);
        redisService.deleteObject(CacheConstants.REDIS_INDEX_AUTHORS);
        redisService.deleteObject(CacheConstants.REDIS_INDEX_POETRY);
        redisService.deleteObject(CacheConstants.REDIS_INDEX_POETRIES);
        List<Part> parts = partService.searchPartRandom(5);
        redisService.setCacheList(CacheConstants.REDIS_INDEX_PARTS, parts);
        List<Author> authors = authorService.searchAuthorRandom(30);
        redisService.setCacheList(CacheConstants.REDIS_INDEX_AUTHORS, authors);
        Poetry poetry=poetryService.getPoetryByRandom();
        redisService.setCacheObject(CacheConstants.REDIS_INDEX_POETRY,poetry);
        List<Poetry> poetryList = poetryService.searchPoetryRandom(CacheConstants.POETRIES_NUMBER);
        redisService.setCacheList(CacheConstants.REDIS_INDEX_POETRIES, poetryList);
        hotWordsService.deleteHotWord(10);
        siteCountService.saveSiteCount();
    }
}

package net.yunzhanyi.client.service.impl;

import lombok.val;
import net.yunzhanyi.client.service.SiteCountService;
import net.yunzhanyi.common.core.constants.CacheConstants;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.domain.domain.SiteCount;
import net.yunzhanyi.domain.mapper.SiteCountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author bestct
 * @date 2023/9/6
 * description: TODO
 */
@Service
public class SiteCountServiceImpl implements SiteCountService {

    @Autowired
    private SiteCountMapper siteCountMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public SiteCount getSiteCount() {
        val ip = redisService.count(CacheConstants.REDIS_SITE_IP).intValue();
        val pv = redisService.getCacheObject(CacheConstants.REDIS_SITE_PV);
        val sumPv = redisService.getCacheObject(CacheConstants.REDIS_SITE_SUM_PV);
        val siteCount = new SiteCount();
        siteCount.setIp(ip);
        siteCount.setPv((Integer) pv);
        siteCount.setSumPv((Integer) sumPv);
        return siteCount;
    }

    @Override
    public void saveSiteCount() {
        val siteCount = getSiteCount();
        val date = new Date(System.currentTimeMillis() - 1000 * 60);
        siteCount.setCollectionDate(date);
        siteCountMapper.insertSelective(siteCount);
        redisService.deleteObject(CacheConstants.REDIS_SITE_IP);
        redisService.deleteObject(CacheConstants.REDIS_SITE_PV);
    }
}

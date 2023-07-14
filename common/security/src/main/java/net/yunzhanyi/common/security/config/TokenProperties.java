package net.yunzhanyi.common.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bestct
 * @date 2023/7/14
 */
@Component
@ConfigurationProperties(prefix = "security.token")
public class TokenProperties {

    /**
     * redis_key前缀
     */
    private String redisKeyPrefix="net:yunzhanyi";

    /**
     * 到期时间
     */
    private Integer expireTime = 60;

    /**
     * 时间单位
     */
    private TimeUnit timeUnit = TimeUnit.MINUTES;

    public String getRedisKeyPrefix() {
        return redisKeyPrefix;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setRedisKeyPrefix(String redisKeyPrefix) {
        this.redisKeyPrefix = redisKeyPrefix;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public static enum TimeUnit {
        /**
         * 天
         */
        DAYS(1000 * 60 * 60 * 24),
        /**
         * 小时
         */
        HOURS(1000 * 60 * 60),
        /**
         * 分钟
         */
        MINUTES(1000 * 60);

        TimeUnit(long millisecond) {
            this.millisecond = millisecond;
        }

        private long millisecond;

        public long getMillisecond() {
            return millisecond;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TimeUnit{");
            sb.append("millisecond=").append(millisecond);
            sb.append('}');
            return sb.toString();
        }
    }
}


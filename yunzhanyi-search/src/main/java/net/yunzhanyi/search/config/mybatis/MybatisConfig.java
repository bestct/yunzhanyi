package net.yunzhanyi.search.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author TingChang
 * @code MybatisConfig
 * @date 2021/4/26
 * description:
 */
@Configuration
@MapperScan("net.yunzhanyi.search.mapper")
public class MybatisConfig {

}

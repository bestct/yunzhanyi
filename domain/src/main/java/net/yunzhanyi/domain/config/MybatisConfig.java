package net.yunzhanyi.domain.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author bestct
 * @date 2023/4/21
 * description: TODO
 */
@MapperScan("net.yunzhanyi.domain.mapper")
@Configuration
public class MybatisConfig {
}

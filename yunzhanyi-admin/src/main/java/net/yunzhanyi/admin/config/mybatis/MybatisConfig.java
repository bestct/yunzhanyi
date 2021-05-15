package net.yunzhanyi.admin.config.mybatis;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author TingChang
 * @code MybatisConfig
 * @date 2021/4/26
 * description:
 */
@Configuration
@MapperScan(basePackages = "net.yunzhanyi.admin.mapper")
public class MybatisConfig {

}

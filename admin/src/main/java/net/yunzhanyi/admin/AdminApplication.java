package net.yunzhanyi.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 管理应用程序
 *
 * @author bestct
 * @date 2023/04/20
 */
@SpringBootApplication
@MapperScan("net.yunzhanyi.**.mapper")
@ComponentScan("net.yunzhanyi")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
        System.out.println("管理端后端已启动");
    }
}

package net.yunzhanyi.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 客户端应用程序
 * @author bestct
 * @date 2023/04/20
 */
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,args);
        System.out.println("客户端启动成功");
    }
}

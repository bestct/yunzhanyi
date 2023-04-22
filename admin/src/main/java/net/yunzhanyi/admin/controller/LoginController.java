package net.yunzhanyi.admin.controller;

import lombok.extern.slf4j.Slf4j;
import net.yunzhanyi.admin.body.LoginBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bestct
 * @date 2023/4/22
 * description: TODO
 */
@RestController
@Slf4j
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestBody LoginBody loginBody){
        log.info(loginBody.toString());
        return "23wqsa";
    }
}

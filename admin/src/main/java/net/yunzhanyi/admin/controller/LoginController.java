package net.yunzhanyi.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.yunzhanyi.admin.body.LoginBody;
import net.yunzhanyi.common.core.AjaxResult;
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
@Tag(name = "LoginController", description = "登录相关接口")
public class LoginController {

    @PostMapping("/login")
    @Operation(summary = "登录",description = "大四")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        log.warn(loginBody.toString());
        return AjaxResult.error("200");
    }
}

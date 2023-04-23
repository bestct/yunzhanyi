package net.yunzhanyi.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import net.yunzhanyi.admin.body.LoginBody;
import net.yunzhanyi.admin.service.LoginService;
import net.yunzhanyi.common.core.AjaxResult;
import net.yunzhanyi.security.model.LoginUser;
import net.yunzhanyi.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Operation(summary = "登录")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        LoginUser loginUser = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        return AjaxResult.success("登录成功", tokenService.createToken(loginUser));
    }
}

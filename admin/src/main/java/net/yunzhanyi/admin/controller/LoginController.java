package net.yunzhanyi.admin.controller;

import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
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

import java.util.Map;

/**
 * 登录控制器
 *
 * @author bestct
 * @date 2023/04/24
 */

@RestController
@Slf4j
@Tag(name = "LoginController", description = "登录相关接口")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CaptchaService captchaService;

    @PostMapping("/login")
    @Operation(summary = "登录")
    public AjaxResult<Map<String,Object>> login(@RequestBody LoginBody loginBody) {
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaVerification(loginBody.getCaptchaVerification());
        if (!captchaService.verification(captchaVO).isSuccess()) {
            return AjaxResult.error("滑动验证失败");
        }
        LoginUser loginUser = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        return AjaxResult.success("登录成功", tokenService.createToken(loginUser));
    }
}

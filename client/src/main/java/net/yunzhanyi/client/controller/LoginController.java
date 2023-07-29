package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.domain.vo.LoginVo;
import net.yunzhanyi.client.service.LoginService;
import net.yunzhanyi.client.task.AsyncFactory;
import net.yunzhanyi.common.core.constants.AccountConstant;
import net.yunzhanyi.common.core.constants.LoginConstant;
import net.yunzhanyi.common.core.utils.StringUtils;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.security.service.TokenService;
import net.yunzhanyi.common.security.utils.SecurityUtils;
import net.yunzhanyi.common.web.manager.AsyncManager;
import net.yunzhanyi.domain.pojo.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author bestct
 * @date 2023/7/14
 */

@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;


    @Autowired
    private TokenService tokenService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/api/login")
    @ResponseBody
    public AjaxResult<Map<String,Object>> login(LoginVo loginVo) {
        LoginUser loginUser = loginService.login(loginVo.getAccount(), loginVo.getPassword());
        AsyncManager.me().execute(AsyncFactory.recordLoginLog(loginUser));
        Map<String, Object> token = tokenService.createToken(loginUser);
        return AjaxResult.success("",token);
    }
    @PostMapping("/api/login/mini")
    @ResponseBody
    public AjaxResult miniLogin(
            @RequestParam("principal") String principal,
            @RequestBody ClientUser user) {
        LoginUser loginUser = loginService.miniLogin(principal, user);
        AsyncManager.me().execute(AsyncFactory.recordLoginLog(loginUser));
        Map<String,Object> token = tokenService.createToken(loginUser);
        return AjaxResult.success(LoginConstant.LOGIN_SUCCESS, token);
    }

    @PostMapping("/api/register")
    @ResponseBody
    public AjaxResult register(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        //判断手机号是否合法
        if (!StringUtils.isMobile(phone)) {
            return AjaxResult.error(AccountConstant.PHONE_ERROR);
        }
        //判断密码是否合法
        if (StringUtils.isEmpty(password) || password.length() < AccountConstant.MIN_PASSWORD_LENGTH) {
            return AjaxResult.error(AccountConstant.PASSWORD_ERROR);
        }
        //判断手机号是否唯一
        if (!loginService.checkPhoneUnique(phone)) {
            return AjaxResult.error(AccountConstant.PHONE_NOT_UNIQUE);
        }

        loginService.register(phone, password);
        return AjaxResult.success(AccountConstant.REGISTER_SUCCESS,null);
    }
    @PostMapping("/api/logout")
    @ResponseBody
    public AjaxResult<String> logout(HttpServletRequest request){
        String token = SecurityUtils.getToken(request);
        tokenService.removeLoginUserToken(token);
        return AjaxResult.success();
    }

}

package net.yunzhanyi.client.controller;

import cn.hutool.core.util.ObjectUtil;
import net.yunzhanyi.client.annotation.CheckLogin;
import net.yunzhanyi.client.annotation.CheckWebLogin;
import net.yunzhanyi.client.domain.vo.SexType;
import net.yunzhanyi.client.service.ClientAccountService;
import net.yunzhanyi.client.service.ClientUserService;
import net.yunzhanyi.client.utils.AuthUtils;
import net.yunzhanyi.common.core.constants.AccountConstant;
import net.yunzhanyi.common.core.constants.UserConstant;
import net.yunzhanyi.common.core.utils.StringUtils;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.security.service.TokenService;
import net.yunzhanyi.common.web.utils.DataMaskingUtils;
import net.yunzhanyi.domain.pojo.ClientAccount;
import net.yunzhanyi.domain.pojo.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author bestct
 * @date 2023/7/15
 * description:
 */
@Controller
public class UserController {

    @Autowired
    private ClientUserService clientUserService;

    @Autowired
    private ClientAccountService clientAccountService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisService redisService;

    @CheckWebLogin
    @GetMapping("/profile")
    public String profile(Model model) {
        ClientUser clientUser = clientUserService.getUserById(AuthUtils.getUserid());
        List<SexType> sexTypeList = new ArrayList<>();
        sexTypeList.add(new SexType("未知", 0));
        sexTypeList.add(new SexType("男", 1));
        sexTypeList.add(new SexType("女", 2));
        model.addAttribute("sexTypeList", sexTypeList);
        model.addAttribute("clientUser", clientUser);
        model.addAttribute("userType", "profile");
        return "profile";
    }

    @CheckWebLogin
    @GetMapping("/account")
    public String account(Model model) {
        ClientAccount account = clientAccountService.findAccountByAid(AuthUtils.getUserid());
        String desensitizePhone = DataMaskingUtils.mobilePhone(account.getPhone());
        String email = DataMaskingUtils.email(account.getEmail());
        model.addAttribute("phone", desensitizePhone);
        model.addAttribute("email", email);
        model.addAttribute("userType", "account");
        return "account";
    }

    @CheckLogin
    @GetMapping("/api/profile")
    @ResponseBody
    public AjaxResult profile() {
        ClientUser clientUser = clientUserService.getUserById(AuthUtils.getUserid());
        return AjaxResult.successWithoutMsg(clientUser);
    }

    @GetMapping("/api/loginUser")
    @ResponseBody
    public AjaxResult<Map<String, Object>> getLoginUser(HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        Map<String, Object> map = new HashMap<>();
        boolean isLogin = ObjectUtil.isNotNull(loginUser);
        map.put("login", isLogin);
        map.put("avatarUrl", isLogin ? loginUser.getAvatarUrl() : "../../static/icon/user.png");
        map.put("nickName", isLogin ? loginUser.getUsername() : "未登录");
        return AjaxResult.successWithoutMsg(map);
    }

    @CheckLogin
    @PostMapping("/api/save/user")
    @ResponseBody
    private AjaxResult saveUser(@RequestBody ClientUser clientUser) {
        long aid = AuthUtils.getUserid();
        clientUser.setAid(aid);
        clientUser.setModifiedTime(new Date());
        if (clientUserService.checkNickNameUnique(clientUser)) {
            clientUserService.saveUser(clientUser);
            redisService.setCacheMapValue(AuthUtils.getRedisTokenKey(), "username", clientUser.getNickName());
            redisService.setCacheMapValue(AuthUtils.getRedisTokenKey(), "avatarUrl", clientUser.getAvatarUrl());
        } else {
            return AjaxResult.error(UserConstant.NICKNAME_ERROR);
        }
        return AjaxResult.success();
    }

    @CheckLogin
    @ResponseBody
    @PostMapping("/api/bind/phone")
    public AjaxResult bindPhone(
            @RequestParam("phone") String phone) {

        if (!StringUtils.isMobile(phone)) {
            return AjaxResult.error(AccountConstant.PHONE_ERROR);
        }
        long aid = AuthUtils.getUserid();
        if (!clientAccountService.checkPhoneUnique(phone)) {
            return AjaxResult.error(AccountConstant.PHONE_NOT_UNIQUE);
        }
        clientAccountService.bindPhone(aid, phone);
        return AjaxResult.success();
    }

    @CheckLogin
    @ResponseBody
    @PostMapping(value = "/api/bind/email")
    public AjaxResult bindEmail(
            @RequestParam("email") String email) {

        if (!StringUtils.isEmail(email)) {
            return AjaxResult.error(AccountConstant.EMAIL_ERROR);
        }
        long aid = AuthUtils.getUserid();
        if (!clientAccountService.checkEmailUnique(email)) {
            return AjaxResult.error(AccountConstant.EMAIL_NOT_UNIQUE);
        }
        clientAccountService.bindEmail(aid, email);
        return AjaxResult.success();
    }


    @CheckLogin
    @PostMapping("/api/change/password")
    @ResponseBody
    public AjaxResult changePassword(@RequestParam String newPassword) {
        long aid = AuthUtils.getUserid();
        if (StringUtils.isEmpty(newPassword) || newPassword.length() < AccountConstant.MIN_PASSWORD_LENGTH) {
            return AjaxResult.error(AccountConstant.PASSWORD_ERROR);
        }
        clientAccountService.changePassword(aid, newPassword);
        return AjaxResult.success();
    }
}

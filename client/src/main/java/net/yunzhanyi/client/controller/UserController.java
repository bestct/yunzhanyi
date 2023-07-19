package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.annotation.CheckLogin;
import net.yunzhanyi.client.annotation.CheckWebLogin;
import net.yunzhanyi.client.domain.vo.SexType;
import net.yunzhanyi.client.service.ClientAccountService;
import net.yunzhanyi.client.service.ClientUserService;
import net.yunzhanyi.client.utils.AuthUtils;
import net.yunzhanyi.common.core.constants.UserConstant;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.redis.service.RedisService;
import net.yunzhanyi.common.web.utils.DataMaskingUtils;
import net.yunzhanyi.domain.pojo.ClientAccount;
import net.yunzhanyi.domain.pojo.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bestct
 * @date 2023/7/15
 * description: TODO
 */
@Controller
public class UserController {

    @Autowired
    private ClientUserService clientUserService;

    @Autowired
    private ClientAccountService clientAccountService;

    @Autowired
    private RedisService redisService;

    @CheckWebLogin
    @GetMapping("/profile")
    public String profile(Model model) {
        ClientUser clientUser = clientUserService.getUserById(AuthUtils.getUserid());
        List<SexType> sexTypeList = new ArrayList<>();
        sexTypeList.add(new SexType("未知",0));
        sexTypeList.add(new SexType("男",  1));
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
    @PostMapping("/api/save/user")
    @ResponseBody
    private AjaxResult saveUser(@RequestBody ClientUser clientUser) {
        long aid = AuthUtils.getUserid();
        clientUser.setAid(aid);
        clientUser.setModifiedTime(new Date());
        if (clientUserService.checkNickNameUnique(clientUser)) {
            clientUserService.saveUser(clientUser);
            redisService.setCacheMapValue(AuthUtils.getRedisTokenKey(), "username", clientUser.getNickName());
        } else {
            return AjaxResult.error(UserConstant.NICKNAME_ERROR);
        }
        return AjaxResult.success();
    }
}

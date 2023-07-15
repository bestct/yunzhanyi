package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.annotation.CheckWebLogin;
import net.yunzhanyi.client.domain.vo.SexType;
import net.yunzhanyi.client.service.ClientAccountService;
import net.yunzhanyi.client.service.ClientUserService;
import net.yunzhanyi.common.security.model.LoginUser;
import net.yunzhanyi.common.web.utils.DataMaskingUtils;
import net.yunzhanyi.domain.pojo.ClientAccount;
import net.yunzhanyi.domain.pojo.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @CheckWebLogin
    @GetMapping("/profile")
    public String profile(HttpServletRequest request, Model model) {
        LoginUser loginUser = (LoginUser) request.getAttribute("loginUser");
        ClientUser clientUser = clientUserService.getUserById(loginUser.getUserid());
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
    public String account(Model model,HttpServletRequest request) {
        LoginUser loginUser = (LoginUser) request.getAttribute("loginUser");
        ClientAccount account = clientAccountService.findAccountByAid(loginUser.getUserid());
        String desensitizePhone = DataMaskingUtils.mobilePhone(account.getPhone());
        String email = DataMaskingUtils.email(account.getEmail());
        model.addAttribute("phone", desensitizePhone);
        model.addAttribute("email", email);
        model.addAttribute("userType", "account");
        return "account";
    }
}

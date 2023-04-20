package net.yunzhanyi.admin.controller;

import net.yunzhanyi.admin.service.AdminUserService;
import net.yunzhanyi.domain.pojo.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理用户控制器
 *
 * @author bestct
 * @date 2023/04/20
 */

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    /**
     * 管理用户服务
     */
    @Autowired
    public AdminUserService adminUserService;

    @GetMapping("/{userid}")
    public AdminUser getUser(@PathVariable Integer userid){
        return adminUserService.getUser(userid);
    }


}

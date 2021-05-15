package net.yunzhanyi.admin.controller;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.dto.RoleDto;
import net.yunzhanyi.admin.service.AdminService;
import net.yunzhanyi.common.model.Admin;
import net.yunzhanyi.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TingChang
 * @code AdminController
 * @date 2021/4/30
 * description:
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.html")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/to/change/password")
    public String toChangePassword() {
        return "password-change";
    }


    @PreAuthorize("hasAuthority('password_change')")
    @PostMapping("/change/password")
    @ResponseBody
    public CommonResult<String> changePasswordByPrimaryKey(String oldPassword, String newPassword, Authentication authentication) {
        User myUser = (User) authentication.getPrincipal();
        String username = myUser.getUsername();
        adminService.changePasswordByUserName(oldPassword, newPassword, username);
        return CommonResult.successWithoutData("修改成功");
    }

    @GetMapping("/admin/manager")
    public String toRoleManager(){
        return "admin-manager";
    }

    @GetMapping("admin/loading")
    @ResponseBody
    public CommonResult<PageInfo<Admin>> loadingRole(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchVal", defaultValue = "") String searchVal
    ){
        PageInfo<Admin> adminPageInfo=adminService.getAdminPageInfo(pageNum,pageSize,searchVal);
        return CommonResult.successWithData(adminPageInfo);
    }

    @GetMapping("to/admin/add")
    public String toAdminAdd(){
        return "admin-add";
    }


    @PreAuthorize("hasAuthority('admin_add')")
    @PostMapping("/admin/add")
    @ResponseBody
    public CommonResult<String> addAdmin(Admin admin){
        adminService.addAdmin(admin);
        return CommonResult.successWithoutData("添加成功");
    }

    @GetMapping("/to/admin/edit/{id}")
    public String toAdminEdit(
            @PathVariable("id") Integer id,
            ModelMap modelMap
    ){
        modelMap.addAttribute("aid",id);
        return "admin-edit";
    }

    @PreAuthorize("hasAuthority('admin_add')")
    @GetMapping("/admin/{aid}")
    @ResponseBody
    public CommonResult<Admin> loadAdmin(
            @PathVariable("aid") Integer aid
    ){
        Admin admin=adminService.getAdminByAid(aid);
        return CommonResult.successWithData(admin);
    }
    @PreAuthorize("hasAuthority('admin_edit')")
    @PostMapping("/admin/edit")
    @ResponseBody
    public CommonResult<String> editAdmin(Admin admin){
        adminService.editAdmin(admin);
        return CommonResult.successWithoutData("修改成功");
    }

    @PreAuthorize("hasAuthority('admin_remove')")
    @PostMapping("/admin/remove")
    @ResponseBody
    public CommonResult<String> removeRole(
            @RequestParam("adminIds") List<Integer> adminIds
    ){
        adminService.removeAdmin(adminIds);
        return CommonResult.successWithoutData("删除成功");
    }
    @GetMapping("to/admin/role/{id}")
    public String toRoleAuthority(
            @PathVariable("id") Integer id,
            ModelMap modelMap
    ){
        modelMap.addAttribute("aid",id);
        return "admin-role";
    }

    @GetMapping("/load/role")
    @ResponseBody
    public CommonResult<RoleDto> loadAuth(
            @RequestParam("aid")String aid
    ){
        RoleDto roleDto=adminService.getAdminRole(aid);
        return CommonResult.successWithData(roleDto);
    }

    @PreAuthorize("hasAuthority('admin_role')")
    @PostMapping(value = "/change/admin/role")
    @ResponseBody
    public CommonResult<String> changeRoleAuth(
            @RequestParam("rids") List<Integer> rids,
            @RequestParam("aid") Integer aid

    ){
       adminService.addAdminRelationship(rids,aid);
        return CommonResult.successWithoutData("分配成功");
    }

}

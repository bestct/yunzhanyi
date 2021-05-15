package net.yunzhanyi.admin.controller;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.dto.AuthorityDto;
import net.yunzhanyi.admin.service.RoleService;
import net.yunzhanyi.common.model.Role;
import net.yunzhanyi.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TingChang
 * @code RoleController
 * @date 2021/5/11
 * description:
 */

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role/manager")
    public String toRoleManager(){
        return "role-manager";
    }

    @GetMapping("role/loading")
    @ResponseBody
    public CommonResult<PageInfo<Role>> loadingRole(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchVal", defaultValue = "") String searchVal
            ){
        PageInfo<Role> rolePageInfo=roleService.getRolePageInfo(pageNum,pageSize,searchVal);
        return CommonResult.successWithData(rolePageInfo);
    }

    @PreAuthorize("hasAuthority('role_add')")
    @PostMapping("/role/add")
    @ResponseBody
    public CommonResult<String> addRole(Role role){
        roleService.addRole(role);
        return CommonResult.successWithoutData("添加成功");
    }

    @PreAuthorize("hasAuthority('role_add')")
    @PostMapping("/role/edit")
    @ResponseBody
    public CommonResult<String> editRole(Role role){
        roleService.editRole(role);
        return CommonResult.successWithoutData("修改成功");
    }

    @PreAuthorize("hasAuthority('role_remove')")
    @PostMapping("/role/remove")
    @ResponseBody
    public CommonResult<String> removeRole(
            @RequestParam("roleIds")List<Integer> roleIds
            ){

        roleService.deleteRole(roleIds);

        return CommonResult.successWithoutData("删除成功");
    }
    @GetMapping("to/role/authority/{id}")
    public String toRoleAuthority(
            @PathVariable("id") Integer id,
            ModelMap modelMap
    ){
        modelMap.addAttribute("rid",id);
        return "role-authority";
    }
    @GetMapping("/load/auth")
    @ResponseBody
    public CommonResult<AuthorityDto> loadAuth(
            @RequestParam("rid")String rid
    ){
        AuthorityDto authorityDto=roleService.getRoleAuth(rid);
        return CommonResult.successWithData(authorityDto);
    }

    @PreAuthorize("hasAuthority('role_auth')")
    @PostMapping(value = "/change/role/auth")
    @ResponseBody
    public CommonResult<String> changeRoleAuth(
            @RequestParam("aids") List<Integer> aids,
            @RequestParam("rid") Integer rid

    ){
        roleService.addRoleRelationship(aids,rid);
        return CommonResult.successWithoutData("分配成功");
    }
}

package net.yunzhanyi.admin.controller;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.service.AuthorityService;
import net.yunzhanyi.common.model.Authority;
import net.yunzhanyi.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author TingChang
 * @code AuthorityController
 * @date 2021/5/9
 * description:
 */

@Controller
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;


    @GetMapping("/authority/manager")
    public String toAuthorityManager(){

        return "authority-manager";
    }

    @GetMapping("/authority/loading")
    @ResponseBody
    public CommonResult<PageInfo<Authority>> loadingData(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchVal", defaultValue = "") String searchVal
    ) {
        PageInfo<Authority> authorityPageInfo = authorityService.loadAuthorityPageInfo(pageNum, pageSize, searchVal);
        return CommonResult.successWithData(authorityPageInfo);
    }

    @PreAuthorize("hasAuthority('authority_add')")
    @PostMapping("/authority/add")
    @ResponseBody
    public CommonResult<String> authorityAdd(Authority authority){

        authorityService.addAuthority(authority);
        return CommonResult.successWithoutData("添加成功");

    }

    @PreAuthorize("hasAuthority('authority_edit')")
    @PostMapping("/authority/edit")
    @ResponseBody
    public CommonResult<String> authorityEdit(Authority authority){

        authorityService.editAuthority(authority);
        return CommonResult.successWithoutData("修改成功");

    }

    @PreAuthorize("hasAuthority('authority_remove')")
    @PostMapping("/authority/remove")
    @ResponseBody
    public CommonResult<String> removeAuthority(@RequestParam("authorityIds") List<Integer> authorityIds) {
        authorityService.removeAuthority(authorityIds);
        return CommonResult.successWithoutData("删除成功");
    }

}

package net.yunzhanyi.admin.controller;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.service.AuthorService;
import net.yunzhanyi.common.model.Author;
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
 * @code AuthorController
 * @date 2021/4/30
 * description:
 */

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/author/manager")
    public String authorManager(){
        return "author-manager";
    }

    @GetMapping("/author/loading")
    @ResponseBody
    public CommonResult<PageInfo<Author>> loadingData(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchVal", defaultValue = "") String searchVal,
            @RequestParam(value = "dynasty",defaultValue = "所有朝代") String dynasty

    ) {
        PageInfo<Author> authorPageInfo = authorService.loadAuthorPageInfo(pageNum, pageSize, searchVal,dynasty);
        return CommonResult.successWithData(authorPageInfo);
    }

    @PreAuthorize("hasAuthority('author_add')")
    @PostMapping("/author/add")
    @ResponseBody
    public CommonResult<String> authorAdd(Author author){

        authorService.addAuthor(author);
        return CommonResult.successWithoutData("添加成功");

    }

    @PreAuthorize("hasAuthority('author_edit')")
    @PostMapping("/author/edit")
    @ResponseBody
    public CommonResult<String> authorEdit(Author author){

        authorService.editAuthor(author);
        return CommonResult.successWithoutData("修改成功");

    }

    @PreAuthorize("hasAuthority('author_remove')")
    @PostMapping("/author/remove")
    @ResponseBody
    public CommonResult<String> removeAuthor(@RequestParam("authorIds") List<Integer> authorIds) {
        authorService.removeAuthor(authorIds);
        return CommonResult.successWithoutData("删除成功");
    }

}

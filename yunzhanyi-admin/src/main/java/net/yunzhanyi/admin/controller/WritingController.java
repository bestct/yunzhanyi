package net.yunzhanyi.admin.controller;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.service.WritingService;
import net.yunzhanyi.common.model.Writing;
import net.yunzhanyi.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TingChang
 * @code WritingController
 * @date 2021/4/30
 * description:
 */
@Controller
public class WritingController {

    @Autowired
    private WritingService writingService;

    @GetMapping("/writing/manager")
    public String toWringManger() {
        return "writing-manager";
    }

    @GetMapping("to/writing/add")
    public String toWringAdd() {
        return "writing-add";
    }

    @GetMapping("/writing/loading")
    @ResponseBody
    public CommonResult<PageInfo<Writing>> loadingData(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchVal", defaultValue = "") String searchVal,
            @RequestParam(value = "type", defaultValue = "所有体裁") String type,
            @RequestParam(value = "dynasty",defaultValue = "所有朝代") String dynasty
    ) {
        PageInfo<Writing> writingPageInfo = writingService.loadWritingPageInfo(pageNum, pageSize, searchVal, type,dynasty);
        return CommonResult.successWithData(writingPageInfo);
    }

    @GetMapping("/to/writing/edit/{id}")
    public String toWritingEdit(
            @PathVariable("id") Integer id,
            ModelMap modelMap
    ){
        modelMap.addAttribute("wid",id);
        return "writing-edit";
    }
    @GetMapping("writing/near/{id}")
    @ResponseBody
    public CommonResult<List<Integer>> writingsLoad(
            @PathVariable("id") Integer id
    ) {
        List<Integer> wids= writingService.getWritingsById(id);
        return CommonResult.successWithData(wids);
    }
    @GetMapping("writing/{id}")
    @ResponseBody
    public CommonResult<Writing> writingLoad(
            @PathVariable("id") Integer id
    ) {
        Writing writing= writingService.getWritingOne(id);
        return CommonResult.successWithData(writing);
    }


    @PreAuthorize("hasAuthority('writing_add')")
    @PostMapping("/writing/add")
    @ResponseBody
    public CommonResult<String> addWriting(Writing writing) {

        writingService.addWriting(writing);
        return CommonResult.successWithoutData("添加成功");
    }

    @PreAuthorize("hasAuthority('writing_remove')")
    @PostMapping("/writing/remove")
    @ResponseBody
    public CommonResult<String> removeWriting(@RequestParam("writingIds") List<Integer> writingIds) {

        writingService.remove(writingIds);
        return CommonResult.successWithoutData("删除成功");
    }

    @PreAuthorize("hasAuthority('writing_edit')")
    @PostMapping("/writing/edit")
    @ResponseBody
    public CommonResult<String> changeWriting(Writing writing) {
        writingService.changeWriting(writing);
        return CommonResult.successWithoutData("修改成功");
    }

}

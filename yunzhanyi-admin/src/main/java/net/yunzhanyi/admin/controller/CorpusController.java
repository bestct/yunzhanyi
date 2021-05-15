package net.yunzhanyi.admin.controller;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.service.CorpusService;
import net.yunzhanyi.common.model.Corpus;
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
 *
 * @code CorpusController
 * @date 2021/4/30
 * description:
 */
@Controller
public class CorpusController {
    @Autowired
    private CorpusService corpusService;


    @GetMapping("/corpus/manager")
    public String corpusManager(){
        return "corpus-manager";
    }

    @GetMapping("/corpus/loading")
    @ResponseBody
    public CommonResult<PageInfo<Corpus>> loadingData(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "searchVal", defaultValue = "") String searchVal
    ) {
        PageInfo<Corpus> corpusPageInfo = corpusService.loadCorpusPageInfo(pageNum, pageSize, searchVal);
        return CommonResult.successWithData(corpusPageInfo);
    }

    @PreAuthorize("hasAuthority('corpus_add')")
    @PostMapping("/corpus/add")
    @ResponseBody
    public CommonResult<String> corpusAdd(Corpus corpus){

        corpusService.addCorpus(corpus);
        return CommonResult.successWithoutData("添加成功");

    }

    @PreAuthorize("hasAuthority('corpus_edit')")
    @PostMapping("/corpus/edit")
    @ResponseBody
    public CommonResult<String> corpusEdit(Corpus corpus){

        corpusService.editCorpus(corpus);
        return CommonResult.successWithoutData("修改成功");

    }
    @PreAuthorize("hasAuthority('corpus_remove')")
    @PostMapping("/corpus/remove")
    @ResponseBody
    public CommonResult<String> removeCorpus(@RequestParam("corpusIds") List<Integer> corpusIds) {
        corpusService.removeCorpus(corpusIds);
        return CommonResult.successWithoutData("删除成功");
    }

}

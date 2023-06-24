package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.domain.vo.CheckResultVo;
import net.yunzhanyi.client.domain.vo.RhymeBookVo;
import net.yunzhanyi.client.domain.vo.RhymeCheckVo;
import net.yunzhanyi.client.service.RhymeService;
import net.yunzhanyi.common.core.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * 押韵控制器
 *
 * @author bestct
 * @date 2023/05/09
 */

@Controller
public class RhymeController {
    /**
     * 韵服务
     */
    @Autowired
    private RhymeService rhymeService;

    @PostMapping("/api/rhyme/check")
    @ResponseBody
    public AjaxResult<CheckResultVo> check(@RequestBody RhymeCheckVo rhymeCheckVo) {
        CheckResultVo checkResultVo = rhymeService.checkRhyme(rhymeCheckVo);
        return AjaxResult.success("完成检查", checkResultVo);
    }

    @GetMapping("/api/rhyme/search")
    @ResponseBody
    public AjaxResult<Collection<RhymeBookVo>> searchRhyme(@RequestParam("hanZi") String hanZi) {
        Map<Integer,RhymeBookVo> rhymeBookVoMap = rhymeService.searchRhyme(hanZi);
        Collection<RhymeBookVo> values = rhymeBookVoMap.values();
        return AjaxResult.success("完成检查",values);
    }

    @GetMapping("/rhyme/check")
    public String check() {
        return "check-rhyme";
    }
}

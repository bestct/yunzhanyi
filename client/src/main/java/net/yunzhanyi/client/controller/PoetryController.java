package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.annotation.AccountPublic;
import net.yunzhanyi.client.domain.vo.PoetryVo;
import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.common.core.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bestct
 * @date 2023/5/28
 * description:
 */
@Controller
public class PoetryController {

    @Autowired
    private PoetryService poetryService;

    @AccountPublic
    @GetMapping("/poetry/{poetryId}")
    public String poetryDetail(@PathVariable Long poetryId, Model model) {
        PoetryVo poetryVo = poetryService.searchWebPoetryById(poetryId);
        model.addAttribute("poetry", poetryVo);
        return "poetry-detail";
    }

    @AccountPublic
    @GetMapping("/api/poetry/{poetryId}")
    @ResponseBody
    public AjaxResult poetryDetail(@PathVariable Long poetryId) {
        PoetryVo poetryVo = poetryService.searchPoetryById(poetryId);
        return AjaxResult.successWithoutMsg(poetryVo);
    }
}

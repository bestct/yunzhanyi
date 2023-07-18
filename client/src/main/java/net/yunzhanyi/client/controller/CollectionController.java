package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.annotation.CheckLogin;
import net.yunzhanyi.client.annotation.CheckWebLogin;
import net.yunzhanyi.client.domain.dto.CollectionDto;
import net.yunzhanyi.client.service.CollectionService;
import net.yunzhanyi.client.utils.AuthUtils;
import net.yunzhanyi.common.core.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bestct
 * @date 2023/7/15
 * description:
 */
@Controller
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @CheckWebLogin
    @GetMapping("/collection")
    public String collection(
            Model model) {
        model.addAttribute("userType", "collection");
        return "collection";
    }

    @CheckLogin
    @GetMapping("/api/collection")
    @ResponseBody
    public AjaxResult<List<CollectionDto>> collection(
            @RequestParam(value = "collectionType", defaultValue = "0") Integer collectionType,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        List<CollectionDto> collectionDtoList = collectionService.getUserApiCollection(AuthUtils.getUserid(), collectionType, pageNum, pageSize);
        return AjaxResult.successWithoutMsg(collectionDtoList);
    }

    @CheckLogin
    @PostMapping("/api/collection")
    @ResponseBody
    public AjaxResult addCollection(@RequestParam Long resId,
                                    @RequestParam(defaultValue = "1") Integer collectionType) {
        collectionService.addCollection(resId, AuthUtils.getUserid(), collectionType);
        return AjaxResult.success();
    }

    @CheckLogin
    @DeleteMapping("/api/collection")
    @ResponseBody
    public AjaxResult cancelCollection(@RequestParam Long resId,
                                       @RequestParam(defaultValue = "1") Integer collectionType) {

        collectionService.cancelCollection(resId, AuthUtils.getUserid(), collectionType);
        return AjaxResult.success();
    }

    @CheckLogin
    @DeleteMapping("/api/collection/{colId}")
    @ResponseBody
    public AjaxResult cancelCollection(@PathVariable Long colId) {
        collectionService.cancelCollectionById(colId);
        return AjaxResult.success();
    }

    @CheckLogin
    @PostMapping("/api/collection/{colId}")
    @ResponseBody
    public AjaxResult reCollection(@PathVariable Long colId) {
        collectionService.reCollectionById(colId);
        return AjaxResult.success();
    }
}

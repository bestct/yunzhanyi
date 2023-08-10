package net.yunzhanyi.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.yunzhanyi.admin.common.annotation.PreventDuplicateSubmit;
import net.yunzhanyi.admin.common.result.PageResult;
import net.yunzhanyi.admin.common.result.Result;
import net.yunzhanyi.admin.model.query.PoetryPageQuery;
import net.yunzhanyi.admin.service.PoetryService;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author bestct
 * @date 2023/7/31
 * description:
 */

@RestController
@Tag(name = "诗词接口")
@RequestMapping("/api/poetry")
@RequiredArgsConstructor
public class PoetryController {
    private final PoetryService poetryService;

    @Operation(summary = "诗词分页列表", security = {@SecurityRequirement(name = "Authorization")})
    @GetMapping("/page")
    public PageResult<Poetry> getPoetryPage(@ParameterObject PoetryPageQuery queryParams) {
        PageInfo<Poetry> listPoetry = poetryService.listPoetry(queryParams);
        PageDTO<Poetry> poetryPageDTO = new PageDTO<>();
        poetryPageDTO.setRecords(listPoetry.getList());
        poetryPageDTO.setTotal(listPoetry.getTotal());
        return PageResult.success(poetryPageDTO);
    }

    @Operation(summary = "单个诗词数据", security = {@SecurityRequirement(name = "Authorization")})
    @GetMapping("/{id}/form")
    public Result<Poetry> getDictForm(
            @Parameter(description ="诗词ID") @PathVariable Long id
    ) {
        Poetry formData = poetryService.getPoetryForm(id);
        return Result.success(formData);
    }

    @Operation(summary = "新增字典", security = {@SecurityRequirement(name = "Authorization")})
    @PostMapping
    @PreAuthorize("@ss.hasPerm('sys:dict:add')")
    @PreventDuplicateSubmit
    public Result saveDict(
            @RequestBody Poetry poetry
    ) {
        boolean result = poetryService.savePoetry(poetry);
        return Result.judge(result);
    }

    @Operation(summary = "修改字典", security = {@SecurityRequirement(name = "Authorization")})
    @PutMapping("/{id}")
    @PreAuthorize("@ss.hasPerm('sys:dict:edit')")
    public Result updateDict(
            @PathVariable Long id,
            @RequestBody Poetry poetry
    ) {
        boolean status = poetryService.updatePoetry(id, poetry);
        return Result.judge(status);
    }

    @Operation(summary = "删除字典", security = {@SecurityRequirement(name = "Authorization")})
    @DeleteMapping("/{ids}")
    @PreAuthorize("@ss.hasPerm('sys:dict:delete')")
    public Result deleteDict(
            @Parameter(description ="字典ID，多个以英文逗号(,)拼接") @PathVariable String ids
    ) {
        boolean result = poetryService.deletePoetry(ids);
        return Result.judge(result);
    }

}

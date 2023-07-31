package net.yunzhanyi.admin.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.yunzhanyi.admin.service.PoetryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

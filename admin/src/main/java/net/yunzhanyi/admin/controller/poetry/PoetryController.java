package net.yunzhanyi.admin.controller.poetry;

import net.yunzhanyi.common.core.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bestct
 * @date 2023/4/23
 * description: TODO
 */
@RestController
public class PoetryController {

    @GetMapping()
    public AjaxResult poetry(){
        return AjaxResult.successWithoutMsg("wns");
    }
}

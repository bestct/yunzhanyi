package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.annotation.CheckLogin;
import net.yunzhanyi.client.service.PerfectService;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.domain.pojo.Perfect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bestct
 * @date 2022/10/3
 * @type 类
 */
@RestController
public class PerfectController {
    @Autowired
    private PerfectService perfectService;

    @PostMapping("/api/perfect")
    @CheckLogin
    public AjaxResult postPerfect(@RequestBody Perfect perfect){
        perfectService.createPerfect(perfect);
        return AjaxResult.success();
    }

}

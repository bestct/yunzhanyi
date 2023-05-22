package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */

@Controller
public class IndexController {


    @Autowired
    private IndexService indexService;

    @GetMapping({"/index", "/"})
    public String index(Model model) {
        Map<String, Object> map = indexService.index();
        model.addAllAttributes(map);
        return "index";
    }
}

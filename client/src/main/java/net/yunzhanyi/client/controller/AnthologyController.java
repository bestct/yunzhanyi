package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.domain.vo.AnthologyVo;
import net.yunzhanyi.client.service.AnthologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author bestct
 * @date 2023/6/19
 * description: TODO
 */

@Controller
public class AnthologyController {

    @Autowired
    private AnthologyService anthologyService;

    @GetMapping("/anthology/{id}")
    public String anthology(@PathVariable Integer id, Model model) {
        AnthologyVo anthologyVo = anthologyService.getAnthologyById(id);
        model.addAttribute("anthologyVo",anthologyVo);
        return "anthology";
    }
}

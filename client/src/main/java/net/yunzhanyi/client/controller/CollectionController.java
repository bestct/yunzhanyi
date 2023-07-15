package net.yunzhanyi.client.controller;

import net.yunzhanyi.client.annotation.CheckWebLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author bestct
 * @date 2023/7/15
 * description: TODO
 */
@Controller
public class CollectionController {

    @CheckWebLogin
    @GetMapping("/collection")
    public String collection(
            Model model) {
        model.addAttribute("userType", "collection");
        return "collection";
    }

}

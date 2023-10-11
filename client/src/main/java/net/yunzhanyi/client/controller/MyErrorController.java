package net.yunzhanyi.client.controller;

import com.alibaba.fastjson.JSON;
import net.yunzhanyi.common.core.vo.AjaxResult;
import net.yunzhanyi.common.web.utils.AjaxUtils;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bestct
 * @date 2022/10/2
 * @type 类
 */
@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        boolean isAjax = AjaxUtils.isAjax(request);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                if (isAjax){
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    AjaxResult error = AjaxResult.error(404, "接口未找到");
                    String string = JSON.toJSONString(error);
                    response.getWriter().print(string);
                    return null;
                }else {
                    return "redirect:/404";
                }
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500";
            }
        }

        // 这里后期可以扩展其他错误页面
        return "404";
    }

    @GetMapping("/404")
    public String page404(){
        return "404";
    }
}

package com.yws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping(value = "/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了。。。");
        request.setAttribute("code", 200);
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg,
                                       @RequestAttribute("code") Integer code,
                                       HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("annotation-msg", msg);
        map.put("annotation-code", code);

        Object msg1 = request.getAttribute("msg");
        map.put("reqMethod-msg", msg1);

        return map;

    }
}

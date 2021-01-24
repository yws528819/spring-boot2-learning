package com.yws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Map<String, Object> success(@RequestAttribute(value = "msg", required = false) String msg,
                                       @RequestAttribute(value = "code", required = false) Integer code,
                                       HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("annotation-msg", msg);
        map.put("annotation-code", code);

        Object msg1 = request.getAttribute("msg");
        map.put("reqMethod-msg", msg1);


        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);

        return map;

    }

    @GetMapping("/params")
    public String testParams(Map<String, Object> map,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) {
        map.put("hello", "world666");
        model.addAttribute("world", "hello6666");
        request.setAttribute("message", "hello, world");

        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success";
    }
}

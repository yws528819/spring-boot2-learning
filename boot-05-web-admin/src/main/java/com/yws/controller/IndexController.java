package com.yws.controller;

import com.yws.bean.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, HttpServletRequest request) {
        if (StringUtils.hasLength(user.getUsername()) && ("12345678").equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "redirect:main.html";
        }else {
            request.setAttribute("msg", "用户名密码校验不通过");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String main(HttpSession session, HttpServletRequest request) {
        if (session.getAttribute("user") == null) {
            request.setAttribute("msg", "请重新登录");
            return "login";
        }
        return "main";
    }

}

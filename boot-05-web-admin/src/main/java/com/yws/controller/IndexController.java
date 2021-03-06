package com.yws.controller;

import com.yws.bean.Account;
import com.yws.bean.City;
import com.yws.bean.User;
import com.yws.service.IAccoutService;
import com.yws.service.ICityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IAccoutService accoutService;

    @Autowired
    private ICityService cityService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city) {
        return cityService.saveCity(city);
    }


    @GetMapping("/city")
    @ResponseBody
    public City getCityById(@RequestParam("id") Long id) {
        return cityService.getById(id);
    }

    @GetMapping("/acct")
    @ResponseBody
    public Account getById(@RequestParam("id") Long id) {
        return accoutService.getById(id);
    }



    @GetMapping("/sql")
    @ResponseBody
    public Long queryFromDB() {
        Long aLong = jdbcTemplate.queryForObject("select count(1) from department", Long.class);
        log.info("记录总数：{}", aLong);

        return aLong;
    }



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

        log.info("当前方法是{}", "mainPage");

//        if (session.getAttribute("user") == null) {
//            request.setAttribute("msg", "请重新登录");
//            return "login";
//        }


        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        String s = operations.get("/main.html");
        String s1 = operations.get("/sql");

        request.setAttribute("mainCount", s);
        request.setAttribute("sqlCount", s1);

        return "main";
    }






}

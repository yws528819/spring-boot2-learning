package com.yws.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(
            @PathVariable("id") String id,
            @PathVariable("username") String username,
            @PathVariable Map<String, String> pv,

            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String, String> headerMap,

            @RequestParam("age") Integer age,
            @RequestParam("interests") List<String> interests,
            @RequestParam Map<String, Object> paramMap

            //@CookieValue("JSESSIONID") Cookie cookie,
            //@CookieValue("JSESSIONID") String cookieValue
            ) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("username", username);
        map.put("pv", pv);

        map.put("userAgent", userAgent);
        map.put("header", headerMap);

        map.put("age", age);
        map.put("interests", interests);
        map.put("paraMap", paramMap);

        //System.out.println(cookie);

        return map;
    }

    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    public Map<String, Object> save(@RequestBody String bodyContent) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", bodyContent);
        System.out.println(bodyContent);
        return map;
    }
}

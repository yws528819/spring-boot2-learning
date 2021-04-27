package com.yws.controller;

import com.yws.bean.Person;
import com.yws.bean.V;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(
            @PathVariable("id") Integer id,
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

    @PostMapping(value = "/save")
    public Map<String, Object> save(@RequestBody String bodyContent) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", bodyContent);
        System.out.println(bodyContent);
        return map;
    }


    //1.语法：请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2.SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量
    //3.矩阵变量必须有url路径变量才能被解析

    // /cars/sell;low=34;brand=byd,audi,yd

    @GetMapping("/cars/{path}")
    public Map<String, Object> carSell(
            @MatrixVariable("low") Integer low,
            @MatrixVariable("brand") List<String> brand,
            @PathVariable("path") String path
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);

        return map;
    }

    // /boss/1;age=30/2;age=24
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(
            @MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
            @MatrixVariable(value = "age", pathVar = "empId") Integer empAge,
            @PathVariable("bossId") String bossId
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        map.put("bossId", bossId);

        return map;
    }


    /**
     * 数据绑定：页面提交的请求数据（GET、POST）都可以和对象属性进行绑定
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveuser(Person person) {
        return person;
    }

    /**
     * http://localhost:8080/test1
     *
     * application/x-www-form-urlencoded  参数转成    v1=1&v2=2
     * 输出 v1=1&v2=2
     *
     * application/json   参数转成 {"v1":"1", "v2":"2"}
     * 输出
     * {
     * 	"v1" : "1",
     * 	"v2" : "2"
     * }
     *
     * @RequestBody  只要你body有啥，就转啥，前提是对的
     *
     * 不加@RequestBody  表单键值对才能转
     *
     */
    @PostMapping("/test1")
    public String test1(@RequestBody  String v1) {
        return v1;
    }

    @PostMapping("/test2")
    public String test2(String v1) {
        return v1;
    }

    @PostMapping("/test3")
    public String test3(@RequestBody V v) {
        return v.toString();
    }

    @PostMapping("/test4")
    public String test4(V v) {
        return v.toString();
    }
}

package com.yws.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user")
    public String getUser() {
        return "张三:GET请求";
    }
    @PostMapping("/user")
    public String saveUser() {
        return "张三:POST请求";
    }
    @PutMapping("/user")
    public String updateUser() {
        return "张三:PUT请求";
    }
    @DeleteMapping("/user")
    public String deleteUser() {
        return "张三:DELETE请求";
    }
}

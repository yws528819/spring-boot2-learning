package com.yws.controller;

import com.yws.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${JAVA_HOME}")
    private String msg;

    @Value("${person.name:李四}")
    private String name;


    @Autowired
    private Person person;

    @GetMapping("/")
    public String hello() {
        return "hello," + name;
    }

    @GetMapping("/person")
    public String person() {
        return person.toString();
    }

    @GetMapping("/msg")
    public String msg() {
        return msg;
    }
}

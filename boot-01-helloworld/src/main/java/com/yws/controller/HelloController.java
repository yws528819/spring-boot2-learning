package com.yws.controller;

import com.yws.bean.Car;
import com.yws.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Car car;

    @Autowired
    private Person person;


    @RequestMapping(value = "/hello")
    public String sayHello() {
        return "Hello, Spring Boot 2!";
    }


    @RequestMapping(value = "/car")
    public Car car() {
        return car;
    }


    @RequestMapping(value = "/person")
    public Person person() {
        return person;
    }

}

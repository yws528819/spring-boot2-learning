package com.yws.controller;

import com.yws.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {
    /**
     * 1.浏览器发请求直接返回xml       [application/xml]    jacksonXmlConverter
     * 2.如果是ajax请求，返回json     [application/json]   jacksonJsonConverter
     * 3.如果ywsapp发请求，返回自定义协议数据  [application/x-yws]  xxxConverter
     *      属性值1;属性值2；
     *
     * 步骤：
     * 1、添加自定义的MessageConverter进系统底层
     * 2、系统底层就会统计出所有的MessageConverter能操作哪些类型
     * 3、客户端内容协商[yws----yws]
     * @return
     */
    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setUserName("lisi");
        person.setAge(15);
        person.setBirth(new Date());
        return person;
    }
}

package com.yws.bean;

import lombok.Data;

@Data
public class Person {
    private String userName;
    private Integer age;

    private Pet pet;
}

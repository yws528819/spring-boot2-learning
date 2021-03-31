package com.yws2.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("test")
@ConfigurationProperties("person")
@Component
@Data
public class Boss implements Person{
    private String name;
    private Integer age;
}

package com.yws2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.HelloService;

@Configuration
public class MyConfig {

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}

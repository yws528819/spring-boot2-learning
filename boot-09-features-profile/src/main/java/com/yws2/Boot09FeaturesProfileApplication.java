package com.yws2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Boot09FeaturesProfileApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Boot09FeaturesProfileApplication.class, args);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        System.out.println(environment.getSystemProperties());
        System.out.println(environment.getSystemEnvironment());
    }

}

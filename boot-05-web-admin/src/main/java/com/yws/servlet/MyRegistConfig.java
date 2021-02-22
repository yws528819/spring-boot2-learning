package com.yws.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet, "/my", "/my02");
    }


    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();

//        return new FilterRegistrationBean(myFilter, myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList(new String[] {"/my", "/css/*"}));
        return filterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        MyServletContextListener myServletContextListener = new MyServletContextListener();

        return new ServletListenerRegistrationBean(myServletContextListener);
    }
}

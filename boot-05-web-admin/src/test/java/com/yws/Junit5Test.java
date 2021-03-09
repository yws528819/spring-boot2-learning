package com.yws;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;

//@SpringBootTest
public class Junit5Test {

    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2() {
        System.out.println(2);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试要开始了。。。");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试结束了。。。");
    }


    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了。。。");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试已经结束了。。。");
    }


    /**
     * 规定方法超过时间，超出时间测试出异常
     */
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testTimeOut() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @RepeatedTest(value = 2)
    void testRepeate() {
        System.out.println("5");
    }

}

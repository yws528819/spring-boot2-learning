package com.yws;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
public class Junit5Test {


    /**
     * 断言：简单断言失败，后面的代码不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(2, 3);
        assertEquals(5, cal, "业务逻辑计算失败");

        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame(obj1, obj2, "两个对象不一样");
    }

    int cal(int i, int j) {
       return i + j;
    }


    @DisplayName("array assertion")
    @Test
    void array() {
        assertArrayEquals(new int[] {2,1}, new int[] {2, 1}, "数组内容不相等");
    }


    @DisplayName("组合断言")
    @Test
    void all() {
        /**
         * 所有断言全部需要成功
         */
        assertAll("test",
                ()-> {
                    assertTrue( true && true, "结果不为TRUE");
                },
                () -> {
                    assertEquals("1", "1", "结果不为1");
                });
    }


    @DisplayName("异常断言")
    @Test
    void testException() {
        assertThrows(ArithmeticException.class, ()-> { int i = 10/0; }, "业务逻辑居然正常运行？");
    }


    @DisplayName("快速失败")
    @Test
    void testFail() {
        if (1 == 2) {
            fail("测试失败");
        }
    }



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

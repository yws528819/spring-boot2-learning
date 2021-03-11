package com.yws;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class MyParameterizedTest {

    @DisplayName("参数化测试")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void testParamterizedTets(int i) {
        System.out.println(i);
    }

    @DisplayName("参数化测试2")
    @ParameterizedTest
    @MethodSource(value = "stringProvide")
    void testParamterizedTets2(String i) {
        System.out.println(i);
    }


    static Stream<String> stringProvide() {
        return Stream.of("apple", "banana", "peach");
    }
}

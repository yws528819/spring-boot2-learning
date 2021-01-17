package com.yws.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dog {
    private String name;
}

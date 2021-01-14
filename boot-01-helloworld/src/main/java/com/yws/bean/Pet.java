package com.yws.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pet {
    private String name;
    private double weight;

    public Pet(String name) {
        this.name = name;
    }
}

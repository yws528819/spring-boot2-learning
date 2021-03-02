package com.yws.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @TableField(exist = false)
    public String username;
    @TableField(exist = false)
    public String password;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}

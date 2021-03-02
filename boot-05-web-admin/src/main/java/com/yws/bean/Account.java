package com.yws.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("tbl_account")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private Long id;
    private String userId;
    private Integer money;
}

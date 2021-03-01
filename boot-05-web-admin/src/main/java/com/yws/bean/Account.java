package com.yws.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table("tbl_account")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private Long id;
    private String userId;
    private Integer money;
}

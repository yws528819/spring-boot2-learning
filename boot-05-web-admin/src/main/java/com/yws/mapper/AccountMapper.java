package com.yws.mapper;

import com.yws.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account getAcct(Long id);
}

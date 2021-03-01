package com.yws.service.impl;

import com.yws.bean.Account;
import com.yws.mapper.AccountMapper;
import com.yws.service.IAccoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccoutService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getById(Long id) {
        return accountMapper.getAcct(id);
    }
}

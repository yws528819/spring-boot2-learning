package com.yws.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yws.bean.User;
import com.yws.mapper.UserMapper;
import com.yws.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}

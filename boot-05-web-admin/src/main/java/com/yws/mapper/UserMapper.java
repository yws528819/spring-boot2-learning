package com.yws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yws.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

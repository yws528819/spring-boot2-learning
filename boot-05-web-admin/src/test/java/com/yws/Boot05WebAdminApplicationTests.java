package com.yws;

import com.yws.bean.User;
import com.yws.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Test
    void contextLoads() {
        //jdbcTemplate.queryForObject("select * from department",);
        Long aLong = jdbcTemplate.queryForObject("select count(1) from department", Long.class);
        log.info("记录总数：{}", aLong);

        log.info("数据源类型：{}", dataSource.getClass());
    }


    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1);
        log.info("用户信息：{}", user);
    }


    @Test
    void testRedis() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        operations.set("hello", "world");

        String hello = operations.get("hello");

        System.out.println(hello);

        System.out.println(redisConnectionFactory.getClass().getName());
    }

}

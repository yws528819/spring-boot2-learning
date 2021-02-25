package com.yws;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        //jdbcTemplate.queryForObject("select * from department",);
        Long aLong = jdbcTemplate.queryForObject("select count(1) from department", Long.class);
        log.info("记录总数：{}", aLong);
    }

}

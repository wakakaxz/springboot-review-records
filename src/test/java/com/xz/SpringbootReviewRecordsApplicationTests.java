package com.xz;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class SpringbootReviewRecordsApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Test
    void contextLoads() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
//        jdbcTemplate.queryForList("select count(*) from user");
        log.info("记录总数: {}", count);
    }
}

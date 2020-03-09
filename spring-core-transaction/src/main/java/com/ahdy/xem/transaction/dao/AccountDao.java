package com.ahdy.xem.transaction.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AccountDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    // b - 1000
    public void reduceMoney() {
        String sql = "update account set salary=salary-? where username=?";
        jdbcTemplate.update(sql, 1000, "b");
    }

    // a + 1000
    public void addMoney() {
        String sql = "update account set salary=salary+? where username=?";
        jdbcTemplate.update(sql, 1000, "a");
    }


}

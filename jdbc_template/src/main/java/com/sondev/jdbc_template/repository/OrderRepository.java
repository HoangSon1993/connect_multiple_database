package com.sondev.jdbc_template.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final JdbcTemplate secondaryJdbcTemplate;

    public OrderRepository(@Qualifier("secondaryJdbcTemplate") JdbcTemplate secondaryJdbcTemplate) {
        this.secondaryJdbcTemplate = secondaryJdbcTemplate;
    }

///  createOrder
    public int createOrder(Long productId, int quantity){
        return 0;
    }
}

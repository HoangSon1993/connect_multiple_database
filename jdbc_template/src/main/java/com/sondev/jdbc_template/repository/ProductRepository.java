package com.sondev.jdbc_template.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private final JdbcTemplate primaryJdbcTemplate;

    public ProductRepository(@Qualifier("primaryJdbcTemplate") JdbcTemplate primaryJdbcTemplate) {
        this.primaryJdbcTemplate = primaryJdbcTemplate;
    }

///  createProduct
    public int createProduct(String name, Double price, Long categoryId){
        return 0;
    }
}

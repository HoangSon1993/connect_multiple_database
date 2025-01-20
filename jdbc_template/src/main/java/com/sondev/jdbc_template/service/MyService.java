package com.sondev.jdbc_template.service;

import com.sondev.jdbc_template.repository.CategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    private final JdbcTemplate primaryJdbcTemplate;
    private final JdbcTemplate secondaryJdbcTemplate;
    private final JdbcTemplate tertiaryJdbcTemplate;
    private final CategoryRepository categoryRepository;

    public MyService(JdbcTemplate primaryJdbcTemplate, JdbcTemplate secondaryJdbcTemplate, JdbcTemplate tertiaryJdbcTemplate, CategoryRepository categoryRepository) {
        this.primaryJdbcTemplate = primaryJdbcTemplate;
        this.secondaryJdbcTemplate = secondaryJdbcTemplate;
        this.tertiaryJdbcTemplate = tertiaryJdbcTemplate;
        this.categoryRepository = categoryRepository;
    }

    public void performDatabaseOperations() {
        // Using PrimaryJdbcTemplate
        String primarySql = "SELECT COUNT(*) FROM product";
        Integer productCount = primaryJdbcTemplate.queryForObject(primarySql, Integer.class);
        System.out.println("Product DB Count: " + productCount);

        // Using SecondaryJdbcTemplate
        String secondarySql = "SELECT COUNT(*) FROM `order`";
        Integer secondaryCount = secondaryJdbcTemplate.queryForObject(secondarySql, Integer.class);
        System.out.println("Order DB count: " + secondaryCount);

        // Using TertiaryJdbcTemplate
        String tertiarySql = "SELECT COUNT(*) FROM category";
        Integer tertiaryCount = tertiaryJdbcTemplate.queryForObject(tertiarySql, Integer.class);
        System.out.println("Category DB count: " + tertiaryCount);
    }

    public int createCategory(String name) {
        return categoryRepository.createCategory(name);
    }
}

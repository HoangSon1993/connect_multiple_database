package com.sondev.jdbc_template.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    private final JdbcTemplate tertiaryJdbcTemplate;

    public CategoryRepository(@Qualifier("tertiaryJdbcTemplate") JdbcTemplate tertiaryJdbcTemplate) {
        this.tertiaryJdbcTemplate = tertiaryJdbcTemplate;
    }

    public int createCategory(String name) {
        String sql = "INSERT INTO category(name) values(?)";
        int count = tertiaryJdbcTemplate.update(sql, name);
        return count;
    }
}

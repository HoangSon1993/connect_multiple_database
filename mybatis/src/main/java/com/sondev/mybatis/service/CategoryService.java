package com.sondev.mybatis.service;

import com.sondev.mybatis.tertiary.entity.Category;
import com.sondev.mybatis.tertiary.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public Category create(String name) {
        Category category = new Category();
        category.setName(name);
        categoryMapper.insert(category);
        return category;
    }
}

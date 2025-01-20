package com.sondev.jpa_hibernate.tertiary.service;

import com.sondev.jpa_hibernate.tertiary.entity.Category;
import com.sondev.jpa_hibernate.tertiary.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(String name){
        Category category= new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }
}

package com.sondev.mybatis.controller;

import com.sondev.mybatis.service.CategoryService;
import com.sondev.mybatis.tertiary.entity.Category;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category createCategory(@RequestParam String name){
        return service.create(name);
    }
}

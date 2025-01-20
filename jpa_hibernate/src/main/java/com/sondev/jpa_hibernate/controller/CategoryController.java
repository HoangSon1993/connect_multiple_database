package com.sondev.jpa_hibernate.controller;

import com.sondev.jpa_hibernate.tertiary.entity.Category;
import com.sondev.jpa_hibernate.tertiary.service.CategoryService;
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
    Category create(@RequestParam String name){
        return service.create(name);
    }
}

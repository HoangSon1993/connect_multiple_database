package com.sondev.jpa_hibernate.controller;

import com.sondev.jpa_hibernate.primary.entity.Product;
import com.sondev.jpa_hibernate.tertiary.entity.Category;
import com.sondev.jpa_hibernate.tertiary.service.CategoryService;
import com.sondev.jpa_hibernate.tertiary.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    Product create(@RequestParam String name, @RequestParam BigDecimal price, @RequestParam Long categoryId){
        return service.create(name, price,categoryId);
    }
}

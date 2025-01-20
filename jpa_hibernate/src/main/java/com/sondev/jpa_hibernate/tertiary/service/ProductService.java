package com.sondev.jpa_hibernate.tertiary.service;

import com.sondev.jpa_hibernate.primary.entity.Product;
import com.sondev.jpa_hibernate.primary.repository.ProductRepository;
import com.sondev.jpa_hibernate.tertiary.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(String name, BigDecimal price, long categoryId){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCategoryId(categoryId);

        return productRepository.save(product);
    }
}

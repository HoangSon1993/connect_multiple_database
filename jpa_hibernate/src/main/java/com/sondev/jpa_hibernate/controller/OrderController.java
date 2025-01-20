package com.sondev.jpa_hibernate.controller;

import com.sondev.jpa_hibernate.primary.entity.Product;
import com.sondev.jpa_hibernate.secondary.entity.Order;
import com.sondev.jpa_hibernate.tertiary.service.OrderService;
import com.sondev.jpa_hibernate.tertiary.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    Order create(@RequestParam Long productId, @RequestParam Integer quantity){
        return service.create(productId,quantity);
    }
}

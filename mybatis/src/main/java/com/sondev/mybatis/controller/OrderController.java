package com.sondev.mybatis.controller;

import com.sondev.mybatis.primary.entity.Product;
import com.sondev.mybatis.primary.mapper.ProductMapper;
import com.sondev.mybatis.secondary.entity.Order;
import com.sondev.mybatis.secondary.mapper.OrderMapper;
import com.sondev.mybatis.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final OrderService orderService;

    public OrderController(OrderMapper orderMapper, ProductMapper productMapper, OrderService orderService) {
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
        this.orderService = orderService;
    }


    @PostMapping
    public Order create(Integer productId, int quantity) {
       return orderService.createOrder(productId,quantity);
    }
}

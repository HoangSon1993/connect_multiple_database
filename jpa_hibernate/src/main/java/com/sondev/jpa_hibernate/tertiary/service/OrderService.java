package com.sondev.jpa_hibernate.tertiary.service;

import com.sondev.jpa_hibernate.primary.entity.Product;
import com.sondev.jpa_hibernate.primary.repository.ProductRepository;
import com.sondev.jpa_hibernate.secondary.entity.Order;
import com.sondev.jpa_hibernate.secondary.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order create(Long productId, Integer quantity) {
        Product product = productRepository.getById(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }
}

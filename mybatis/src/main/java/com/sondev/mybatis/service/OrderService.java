package com.sondev.mybatis.service;

import com.sondev.mybatis.primary.entity.Product;
import com.sondev.mybatis.primary.mapper.ProductMapper;
import com.sondev.mybatis.secondary.entity.Order;
import com.sondev.mybatis.secondary.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;

    public OrderService(OrderMapper orderMapper, ProductMapper productMapper) {
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
    }

    public Order createOrder(Integer productId, int quantity) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        orderMapper.insert(order);
        return order;
    }
}

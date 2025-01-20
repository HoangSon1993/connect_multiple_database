package com.sondev.jpa_hibernate.secondary.repository;

import com.sondev.jpa_hibernate.secondary.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}

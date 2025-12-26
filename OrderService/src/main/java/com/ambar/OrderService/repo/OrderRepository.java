package com.ambar.OrderService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambar.OrderService.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}


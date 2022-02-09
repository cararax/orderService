package com.carara.orderService.repositories;

import com.carara.orderService.entities.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}

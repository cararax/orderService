package com.carara.orderService.repositories;

import com.carara.orderService.entities.ClientModel;
import com.carara.orderService.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}

package com.carara.orderService.controllers;

import com.carara.orderService.entities.OrderModel;
import com.carara.orderService.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @GetMapping
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderModel> findById(@PathVariable Long id) {
        OrderModel order = repository.findById(id).get();
        return ResponseEntity.ok(order);
    }

}

package com.carara.orderService;

import com.carara.orderService.entities.ClientModel;
import com.carara.orderService.entities.OrderModel;
import com.carara.orderService.entities.OrderStatusEnum;
import com.carara.orderService.entities.ProductModel;
import com.carara.orderService.repositories.ClientRepository;
import com.carara.orderService.repositories.OrderRepository;
import com.carara.orderService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.Arrays;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ClientModel cliente1 = new ClientModel(null, "Alex Green", "alex@gmail.com");
        clientRepository.save(cliente1);

        ProductModel product1 = new ProductModel(null, "TV", 1000.0);
        ProductModel product2 = new ProductModel(null, "Mouse", 40.0);
        ProductModel product3 = new ProductModel(null, "PC", 1200.0);
        productRepository.saveAll(Arrays.asList(product1, product2, product3));

        OrderModel order1 = new OrderModel(null, Instant.parse("2022-02-09T11:25:09Z"), OrderStatusEnum.PAID, cliente1);
        OrderModel order2 = new OrderModel(null, Instant.parse("2022-02-09T13:30:00Z"), OrderStatusEnum.WAITING, cliente1);
        orderRepository.saveAll(Arrays.asList(order1, order2));

    }
}

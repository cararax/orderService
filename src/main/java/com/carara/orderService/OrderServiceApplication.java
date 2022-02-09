package com.carara.orderService;

import com.carara.orderService.entities.ClientModel;
import com.carara.orderService.entities.ProductModel;
import com.carara.orderService.repositories.ClientRepository;
import com.carara.orderService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OrderServiceApplication implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ClientModel cliente1 = new ClientModel(null, "Alex Green", "alex@gmail.com");
        clientRepository.save(cliente1);

        ProductModel p1 = new ProductModel(null, "TV", 1000.0);
        ProductModel p2 = new ProductModel(null, "Mouse", 40.0);
        ProductModel p3 = new ProductModel(null, "PC", 1200.0);

        productRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}

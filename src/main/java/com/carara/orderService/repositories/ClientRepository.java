package com.carara.orderService.repositories;

import com.carara.orderService.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
}

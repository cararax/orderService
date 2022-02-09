package com.carara.orderService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_order_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @JsonIgnore
    //impede a serialização de OrderModel ao buscar pelo OrderItem, barrando um ciclo infinito ja que o mapeamento é bidirecional
    @ManyToOne
    @JoinColumn(name = "order_id")      //associação bidirecional
    private OrderModel order;
}

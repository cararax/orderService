package com.carara.orderService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;
    private OrderStatusEnum status;

    @ManyToOne                          //associação um para um
    @JoinColumn(name = "client_id")     //especifica a chave estrangeira
    private ClientModel client;
    //relacionamento bidirecional com OrdemItemModel
    @OneToMany(mappedBy = "order")      //especifica que é mapeado pelo atributo order do OrderItemModel
    private List<OrderItemModel> items = new ArrayList<>();

    public OrderModel(Long id, Instant moment, OrderStatusEnum status, ClientModel client) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
    }
}

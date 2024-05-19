package com.fiapfastfood.groupfoursix.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Order {

    @Id
    private String id;
    private OrderStatus orderStatus;

    public Order() {

    }

    public Order(String id) {
        this.id = id;
        this.orderStatus = OrderStatus.PROGRESS;
    }

    public Order(String number, OrderStatus orderStatus) {
        this.id = number;
        this.orderStatus = orderStatus;
    }
}

package com.fiapfastfood.groupfoursix.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@ToString
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

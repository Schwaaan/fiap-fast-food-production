package com.fiapfastfood.groupfoursix.domain;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getId() {
        Order order = new Order();
        order.setId("1");
        assertEquals("1", order.getId());
    }

    @Test
    void getOrderStatus() {
        Order order = new Order();
        order.setId("1");
        order.setOrderStatus(OrderStatus.PROGRESS);
        assertEquals("1", order.getId());
        assertEquals(OrderStatus.PROGRESS, order.getOrderStatus());
    }

    @Test
    void setId() {
        Order order = new Order();
        order.setId("1");
        assertEquals("1", order.getId());
    }

    @Test
    void setOrderStatus() {
        Order order = new Order();
        order.setId("1");
        order.setOrderStatus(OrderStatus.PROGRESS);
        assertEquals("1", order.getId());
        assertEquals(OrderStatus.PROGRESS, order.getOrderStatus());
    }
}
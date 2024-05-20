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
    void setStatus() {
        Order order = new Order();
        order.setOrderStatus(OrderStatus.PROGRESS);
        assertEquals(OrderStatus.PROGRESS, order.getOrderStatus());
    }

    @Test
    void setOrderStatus() {
        Order order = new Order();
        order.setId("1");
        order.setOrderStatus(OrderStatus.PROGRESS);
        assertEquals("1", order.getId());
        assertEquals(OrderStatus.PROGRESS, order.getOrderStatus());
    }

    @Test
    public void testHashCode() {
        Order order1 = new Order("1", OrderStatus.PROGRESS);
        Order order2 = new Order("1", OrderStatus.PROGRESS);
        assertEquals(order1.hashCode(), order2.hashCode());
    }

    @Test
    public void testEquals() {
        Order order1 = new Order("1", OrderStatus.PROGRESS);
        Order order2 = new Order("1", OrderStatus.PROGRESS);
        Order order3 = new Order("2", OrderStatus.PROGRESS);

        assertTrue(order1.equals(order2));
        assertFalse(order1.equals(order3));
    }

    @Test
    public void testCanEqual() {
        Order order1 = new Order("1", OrderStatus.PROGRESS);
        Order order2 = new Order("1", OrderStatus.PROGRESS);

        assertTrue(order1.canEqual(order2));
    }

    @Test
    public void testToString() {
        Order order = new Order("1", OrderStatus.PROGRESS);

        String expectedToString = "Order(id=1, orderStatus=PROGRESS)";
        assertEquals(expectedToString, order.toString());
    }
}
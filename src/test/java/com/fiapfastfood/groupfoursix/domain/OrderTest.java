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
        assertEquals(order1.hashCode(), order2.hashCode());

        assertFalse(order1.equals(order3));
        assertNotEquals(order1.hashCode(), order3.hashCode());

        assertFalse(order1.equals(null));

        assertFalse(order1.equals("order"));

        assertTrue(order2.equals(order1));

        Order order4 = new Order("1", OrderStatus.PROGRESS);
        assertTrue(order1.equals(order2) && order2.equals(order4) && order1.equals(order4));

        assertTrue(order1.equals(order2));
        order2.setId("3");
        assertFalse(order1.equals(order2));

        Order order5 = new Order("1", OrderStatus.DONE);
        assertFalse(order1.equals(order5));

        int originalHashCode = order1.hashCode();
        order1.setId("5");
        assertNotEquals(originalHashCode, order1.hashCode());

        Order order6 = new Order();
        order6.setId("6");
        order6.setOrderStatus(OrderStatus.PROGRESS);
        assertEquals("6", order6.getId());
        assertEquals(OrderStatus.PROGRESS, order6.getOrderStatus());
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
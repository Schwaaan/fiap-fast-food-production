package com.fiapfastfood.groupfoursix.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderStatusTest {

    @Test
    void from1() {
        OrderStatus orderStatus = OrderStatus.from(1L);
        assertEquals(OrderStatus.PROGRESS, orderStatus);
        assertEquals(OrderStatus.PROGRESS.getDescription(), orderStatus.getDescription());
    }

    @Test
    void from2() {
        OrderStatus orderStatus = OrderStatus.from(2L);
        assertEquals(OrderStatus.DONE, orderStatus);
        assertEquals(OrderStatus.DONE.getDescription(), orderStatus.getDescription());
    }

    @Test
    void from3() {
        OrderStatus orderStatus = OrderStatus.from(3L);
        assertEquals(OrderStatus.CANCEL, orderStatus);
        assertEquals(OrderStatus.CANCEL.getDescription(), orderStatus.getDescription());
    }

    @Test
    void fromIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            OrderStatus.from(5L);
        });
    }
}
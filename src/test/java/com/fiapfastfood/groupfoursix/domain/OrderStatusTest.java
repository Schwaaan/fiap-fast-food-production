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
    }

    @Test
    void from2() {
        OrderStatus orderStatus = OrderStatus.from(2L);
        assertEquals(OrderStatus.DONE, orderStatus);
    }

    @Test
    void from3() {
        OrderStatus orderStatus = OrderStatus.from(3L);
        assertEquals(OrderStatus.CANCEL, orderStatus);
    }

    @Test
    void fromIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            OrderStatus.from(5L);
        });
    }
}
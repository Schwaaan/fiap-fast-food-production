package com.fiapfastfood.groupfoursix.domain.dto;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDTOTest {

    @Test
    void getId() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("2");
        assertEquals("2", orderDTO.getId());
    }
}
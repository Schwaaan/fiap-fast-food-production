package com.fiapfastfood.groupfoursix.domain.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OrderDTOTest {

    @Test
    void getId() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("2");
        assertEquals("2", orderDTO.getId());
    }
}
package com.fiapfastfood.groupfoursix.domain.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusDTOTest {

    @Test
    void getOrderId() {
        StatusDTO statusDTO = new StatusDTO("2", 1L);
        assertEquals("2", statusDTO.getOrderId());
        assertEquals(1L, statusDTO.getStatusId());
    }
}
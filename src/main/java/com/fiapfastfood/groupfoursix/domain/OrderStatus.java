package com.fiapfastfood.groupfoursix.domain;

import lombok.Getter;

@Getter
public enum OrderStatus {

    PROGRESS("Em preparação", 1L),
    DONE("Concluído", 2L),
    CANCEL("Cancelado", 3L);

    private String description;
    private Long id;

    OrderStatus(String description, Long id) {
        this.description = description;
        this.id = id;
    }

    public static OrderStatus from(Long id) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("ID inválido para StatusEnum: " + id);
    }
}

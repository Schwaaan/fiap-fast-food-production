package com.fiapfastfood.groupfoursix.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusDTO {

    private String orderId;
    private Long statusId;

}

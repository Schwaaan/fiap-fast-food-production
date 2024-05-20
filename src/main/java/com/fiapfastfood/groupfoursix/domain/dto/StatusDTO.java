package com.fiapfastfood.groupfoursix.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatusDTO {

    private String orderId;
    private Long statusId;

}

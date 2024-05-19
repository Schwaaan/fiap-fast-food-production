package com.fiapfastfood.groupfoursix.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {

    private String orderId;
    private Long statusId;

}

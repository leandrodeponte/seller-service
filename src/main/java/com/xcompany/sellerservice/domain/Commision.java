package com.xcompany.sellerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Commision {
    private String type;
    private String method;
    private Long value;
}

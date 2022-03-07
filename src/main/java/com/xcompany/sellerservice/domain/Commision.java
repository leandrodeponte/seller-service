package com.xcompany.sellerservice.domain;

import lombok.Data;

@Data
public class Commision {
    private String saleType;
    private String method;
    private Long value;
}

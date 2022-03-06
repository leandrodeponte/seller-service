package com.xcompany.sellerservice.domain;

import lombok.Data;

@Data
public abstract class Sell {
    private String sellerId;
    private String clientEmail;
    private Product product;
    private String saleType;
}

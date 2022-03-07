package com.xcompany.sellerservice.usecase.comissioncalculator.config;

import com.xcompany.sellerservice.domain.Commision;
import com.xcompany.sellerservice.domain.Sell;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "commisions")
public class CommisionConfig {

    //This configuration could be stored in other manners

    private List<Commision> list;

    public Commision get(Sell sell){
        return list.stream()
                .filter(c -> c.getType().equalsIgnoreCase(sell.getSaleType()))
                .findAny()
                .orElse(null);
    }
}

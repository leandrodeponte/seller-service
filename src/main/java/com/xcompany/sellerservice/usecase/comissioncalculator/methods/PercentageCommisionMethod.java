package com.xcompany.sellerservice.usecase.comissioncalculator.methods;

import com.xcompany.sellerservice.domain.Commision;
import com.xcompany.sellerservice.domain.Product;
import com.xcompany.sellerservice.domain.Sell;
import com.xcompany.sellerservice.usecase.comissioncalculator.config.CommisionConfig;
import org.springframework.stereotype.Component;

@Component
public class PercentageCommisionMethod implements CommisionMethod {

    private CommisionConfig commisionConfig;

    PercentageCommisionMethod(CommisionConfig commisionConfig){
        this.commisionConfig = commisionConfig;
    }

    @Override
    public Long calculate(Sell sell) {
        Commision commision = commisionConfig.get(sell);
        Product product = sell.getProduct();
        return product.getPrice() + (product.getPrice() * commision.getValue());
    }

    @Override
    public boolean shouldCalculate(Sell sell) {
        Commision commision = commisionConfig.get(sell);
        return "percentage".equalsIgnoreCase(commision.getMethod());
    }
}

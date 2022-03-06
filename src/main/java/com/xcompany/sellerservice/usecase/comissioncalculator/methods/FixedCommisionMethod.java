package com.xcompany.sellerservice.usecase.comissioncalculator.methods;

import com.xcompany.sellerservice.domain.Commision;
import com.xcompany.sellerservice.domain.Product;
import com.xcompany.sellerservice.domain.Sell;
import com.xcompany.sellerservice.usecase.comissioncalculator.config.CommisionConfig;
import org.springframework.stereotype.Component;

@Component
public class FixedCommisionMethod implements CommisionMethod {

    private CommisionConfig commisionConfig;

    FixedCommisionMethod(CommisionConfig commisionConfig){
        this.commisionConfig = commisionConfig;
    }

    @Override
    public Long calculate(Sell sell) {
        Commision commision = commisionConfig.get(sell);
        return commision.getValue();
    }

    @Override
    public boolean shouldCalculate(Sell sell) {
        Commision commision = commisionConfig.get(sell);
        return "fixed".equalsIgnoreCase(commision.getMethod());
    }
}

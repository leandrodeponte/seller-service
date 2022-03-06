package com.xcompany.sellerservice.usecase.comissioncalculator.methods;

import com.xcompany.sellerservice.domain.Sell;

public interface CommisionMethod {
    Long calculate(Sell sell);
    boolean shouldCalculate(Sell sell);
}

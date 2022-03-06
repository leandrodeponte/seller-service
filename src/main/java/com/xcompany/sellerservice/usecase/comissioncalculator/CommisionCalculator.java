package com.xcompany.sellerservice.usecase.comissioncalculator;

import com.xcompany.sellerservice.domain.Sell;
import com.xcompany.sellerservice.usecase.comissioncalculator.methods.CommisionMethod;
import com.xcompany.sellerservice.usecase.port.SellStore;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommisionCalculator {

    private SellStore sellStore;
    private List<CommisionMethod> commisionMethods;

    CommisionCalculator(SellStore sellStore){
        this.sellStore = sellStore;
    }

    public Long getSellerCommision(Date fromtDate, Date toDate, String sellerId){
        List<Sell> sells = sellStore.getSells( fromtDate,  toDate,  sellerId);
        Long totalCommision = 0L;
        for(Sell s : sells){
            totalCommision += calculateCommision(s);
        }
        return totalCommision;
    }

    private Long calculateCommision(Sell sell){
        for(CommisionMethod c : commisionMethods){
           if(c.shouldCalculate(sell)){
               return c.calculate(sell);
           }
        }
        return 0L;
    }
}

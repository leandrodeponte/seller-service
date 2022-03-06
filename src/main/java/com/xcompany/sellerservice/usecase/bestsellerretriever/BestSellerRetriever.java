package com.xcompany.sellerservice.usecase.bestsellerretriever;

import com.xcompany.sellerservice.usecase.port.SellStore;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BestSellerRetriever {

    private SellStore sellStore;

    public BestSellerRetriever(SellStore sellStore){
        this.sellStore = sellStore;
    }

    public String getBestSellerId(Date date){
        sellStore.getSells( date);
    }
}

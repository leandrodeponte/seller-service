package com.xcompany.sellerservice.usecase.bestsellerretriever;

import com.xcompany.sellerservice.domain.Sell;
import com.xcompany.sellerservice.usecase.port.SellStore;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BestSellerRetriever {

    private SellStore sellStore;

    public BestSellerRetriever(SellStore sellStore){
        this.sellStore = sellStore;
    }

    public String getBestSellerId(Date date){
        List<Sell> sells = sellStore.getSells(date);
        Map<String, Long> sellers = new HashMap<>();
        for(Sell s : sells) {
            Long currentValue = 0L;
            if(sellers.containsKey(s.getSellerId())){
                currentValue = sellers.get(s.getSellerId());
            }
            sellers.put(s.getSellerId(), s.getProduct().getPrice() + currentValue);
        }
        return getHighestValueSeller(sellers);
    }

    private String getHighestValueSeller(Map<String, Long> sellers){
        Long highestValue = 0l;
        String sellerId = null;
        for (Map.Entry<String, Long> entry : sellers.entrySet()) {
            if (entry.getValue() >= highestValue) {
                highestValue = entry.getValue();
                sellerId = entry.getKey();
            }
        }
        return sellerId;
    }
}

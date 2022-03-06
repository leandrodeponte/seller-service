package com.xcompany.sellerservice.usecase.port;


import com.xcompany.sellerservice.domain.Sell;

import java.util.Date;
import java.util.List;

public interface SellStore {
    void save(Sell sell);
    List<Sell> getSells(Date date);
    List<Sell> getSells(Date fromDate, Date toDate, String sellerId);
}

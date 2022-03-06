package com.xcompany.sellerservice.usecase.port;

import com.xcompany.sellerservice.domain.Sell;

public interface EmailSender {
    void sendMail(Sell sell);
}

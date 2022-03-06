package com.xcompany.sellerservice.usecase.executesale;

import com.xcompany.sellerservice.domain.Sell;
import com.xcompany.sellerservice.usecase.port.EmailSender;
import com.xcompany.sellerservice.usecase.port.SaleScreenPrinter;
import com.xcompany.sellerservice.usecase.port.SellStore;
import org.springframework.stereotype.Service;

@Service
public class ExecuteSale {

    private SellStore sellStore;
    private SaleScreenPrinter saleScreenPrinter;
    private EmailSender emailSender;

    public ExecuteSale(SellStore sellStore, SaleScreenPrinter saleScreenPrinter, EmailSender emailSender){
        this.sellStore = sellStore;
        this.saleScreenPrinter = saleScreenPrinter;
        this.emailSender = emailSender;
    }

    public void execute( Sell sale ){
        sellStore.save(sale);
        emailSender.sendMail(sale);
        saleScreenPrinter.printer(sale);
    }

}

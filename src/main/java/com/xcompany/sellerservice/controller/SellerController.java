package com.xcompany.sellerservice.controller;

import com.xcompany.sellerservice.domain.SaleTypeA;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            import com.xcompany.sellerservice.domain.SaleTypeB;
   import com.xcompany.sellerservice.domain.SaleTypeC;
   import com.xcompany.sellerservice.usecase.executesale.ExecuteSale;
   import org.springframework.stereotype.Controller;

   @Controller
   public class SellerController {

   //Maybe it should receive a generic sale, with the type on the payload and refuses (400)

   private ExecuteSale executeSale;

    SellerController(ExecuteSale executeSale){
        this.executeSale = executeSale;
    }

    public void sellTypeA(SaleTypeA sale){
        executeSale.execute(sale);
    }

    public void sellTypeB(SaleTypeB sale){
        executeSale.execute(sale);
    }

    public void sellTypeC(SaleTypeC sale){
        executeSale.execute(sale);
    }

}

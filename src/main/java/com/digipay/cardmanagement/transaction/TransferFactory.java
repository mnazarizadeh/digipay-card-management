package com.digipay.cardmanagement.transaction;

import org.springframework.stereotype.Component;

@Component
public class TransferFactory {

    public Transfer getTransfer(String bin){
        if(bin == null){
            return null;
        }
        if(bin.equalsIgnoreCase("502229")){
            return new Pasargad();

        } else {
            return new Other();

        }
    }
}

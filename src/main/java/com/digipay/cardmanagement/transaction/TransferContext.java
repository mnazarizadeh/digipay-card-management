package com.digipay.cardmanagement.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TransferContext {

    private final List<Transfer> transfers;
    private final Other other;

    public Transfer getTransfer(String bin){
        return transfers.stream().filter(t -> t.supportedPrefix().contains(bin)).findAny().orElse(other);
    }
}

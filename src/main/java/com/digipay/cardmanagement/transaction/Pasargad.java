package com.digipay.cardmanagement.transaction;

import com.digipay.cardmanagement.dto.TransferDTO;
import com.digipay.cardmanagement.entity.CardEntity;
import com.digipay.cardmanagement.entity.TransactionEntity;
import com.digipay.cardmanagement.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class Pasargad implements Transfer{

    TransactionEntity transaction;

    @Override
    public TransactionEntity send() {
        if (transaction == null || transaction.getId() == null)
            throw new BadRequestException();

        // do something for transfer

        transaction.setVerified(true);
        return transaction;
    }

    @Override
    public TransactionEntity createTransaction(CardEntity card, TransferDTO transferDTO){
        transaction = new TransactionEntity();

        transaction.setSource(card);
        transaction.setDestination(transferDTO.getDestination());
        transaction.setAmount(transferDTO.getAmount());
        transaction.setStartTransaction(LocalDateTime.now());
        transaction.setVerified(false);

        return transaction;
    }

    @Override
    public List<String> supportedPrefix() {
        return Arrays.asList("502229");
    }


}

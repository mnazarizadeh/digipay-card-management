package com.digipay.cardmanagement.transaction;

import com.digipay.cardmanagement.dto.TransferDTO;
import com.digipay.cardmanagement.entity.CardEntity;
import com.digipay.cardmanagement.entity.TransactionEntity;
import com.digipay.cardmanagement.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class Other implements Transfer{

    TransactionEntity transaction;

    @Override
    public TransactionEntity send() {
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
        return null;
    }
}

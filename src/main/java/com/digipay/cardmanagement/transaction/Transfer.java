package com.digipay.cardmanagement.transaction;

import com.digipay.cardmanagement.dto.TransferDTO;
import com.digipay.cardmanagement.entity.CardEntity;
import com.digipay.cardmanagement.entity.TransactionEntity;
import org.springframework.transaction.reactive.TransactionalOperator;

import java.util.List;

public interface Transfer {

    TransactionEntity send();

    TransactionEntity createTransaction(CardEntity card, TransferDTO transferDTO);

    List<String> supportedPrefix();
}

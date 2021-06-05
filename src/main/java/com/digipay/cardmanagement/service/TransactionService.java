package com.digipay.cardmanagement.service;


import com.digipay.cardmanagement.dto.TransactionDTO;
import com.digipay.cardmanagement.dto.TransferDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    /**
     * retrieve merchant's verified transaction with pagination
     *
     * @param merchantId    the ID of merchant which requested theirs transactions
     * @param pageable      pagination properties like page number, page size and sorting format
     * @return              a page of transactions regarding merchant
     */
    Page<TransactionDTO> getMerchantTransactions(Long merchantId, Pageable pageable);

    /**
     * transfer money from one card to another
     * @param merchantId    the ID of merchant which requested theirs transactions
     * @param transferDTO   transferSTO contains source and destination card number, amount of money to be deposited and source card info
     * @return              transaction detail which inserted to DB
     */
    TransactionDTO transfer(Long merchantId, TransferDTO transferDTO);

}

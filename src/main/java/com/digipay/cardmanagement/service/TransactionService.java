package com.digipay.cardmanagement.service;


import com.digipay.cardmanagement.dto.TransactionDTO;
import com.digipay.cardmanagement.dto.TransferDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {

    Page<TransactionDTO> getMerchantTransactions(Long merchantId, Pageable pageable);

    TransactionDTO transfer(Long merchantId, TransferDTO transferDTO);

}

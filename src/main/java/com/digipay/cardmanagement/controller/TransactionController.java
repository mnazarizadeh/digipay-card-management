package com.digipay.cardmanagement.controller;

import com.digipay.cardmanagement.dto.TransactionDTO;
import com.digipay.cardmanagement.dto.TransferDTO;
import com.digipay.cardmanagement.service.TransactionService;
import com.digipay.cardmanagement.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * {@code POST  /transfer} : transfer money
     *
     * @param merchantId    the ID of merchant in the header or sometimes could be a token
     * @param transferDTO   the transfer details
     * @return              transaction DTO
     */
    @PostMapping("/transfer")
    public ResponseEntity<TransactionDTO> transfer(@RequestHeader(value = "merchantId") Long merchantId,
                                                   @RequestBody TransferDTO transferDTO) {
        log.debug("REST request do a transfer : {}", transferDTO);

        TransactionDTO result = transactionService.transfer(merchantId, transferDTO);

        return ResponseEntity.ok()
                .body(result);
    }

    /**
     * {@code GET  /transactions} : retrieve list of merchant's verified transactions
     *
     * @param merchantId    the ID of merchant in the header or sometimes could be a token
     * @param pageable      pagination info
     * @return              list of transactions related to the merchant
     */
    @GetMapping("/transactions")
    public ResponseEntity<?> getAllTransactions(@RequestHeader(value = "merchantId") Long merchantId,
                                                 Pageable pageable) {
        log.debug("REST request to get a page of transactions for merchantId : {}", merchantId);

        Page<TransactionDTO> page = transactionService.getMerchantTransactions(merchantId, pageable);
        return ResponseEntity.ok()
                .headers(PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page))
                .body(page.getContent());
    }

}

package com.digipay.cardmanagement.service;

import com.digipay.cardmanagement.dto.TransactionDTO;
import com.digipay.cardmanagement.dto.TransferDTO;
import com.digipay.cardmanagement.entity.CardEntity;
import com.digipay.cardmanagement.entity.TransactionEntity;
import com.digipay.cardmanagement.exception.InvalidCardInfoException;
import com.digipay.cardmanagement.exception.UnauthorizedException;
import com.digipay.cardmanagement.mapper.CardMapper;
import com.digipay.cardmanagement.mapper.MerchantMapper;
import com.digipay.cardmanagement.mapper.TransactionMapper;
import com.digipay.cardmanagement.repository.CardRepository;
import com.digipay.cardmanagement.repository.TransactionRepository;
import com.digipay.cardmanagement.transaction.Transfer;
import com.digipay.cardmanagement.transaction.TransferFactory;
import com.digipay.cardmanagement.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;
    private final CardMapper cardMapper;
    private final MerchantMapper merchantMapper;
    private final TransactionMapper transactionMapper;

    @Transactional
    public Page<TransactionDTO> getMerchantTransactions(Long merchantId, Pageable pageable) {
        return transactionRepository.findBySourceMerchantIdAndVerifiedIsTrue(merchantId, pageable)
                .map(transactionMapper::toDto);
    }

    @Transactional
    public TransactionDTO transfer(Long merchantId, TransferDTO transferDTO) {
        CardEntity card = cardRepository.findByPanAndActiveIsTrue(transferDTO.getSource()).orElseThrow(UnauthorizedException::new);

        validateMerchant(card, merchantId);

        validateCardInfo(card, transferDTO);

        TransferFactory transferFactory = new TransferFactory();

        Transfer transfer = transferFactory.getTransfer(card.getPan().substring(0,6));

        transactionRepository.save(transfer.createTransaction(card, transferDTO));

        return transactionMapper.toDto(transfer.send());
    }

    private void validateCardInfo(CardEntity card, TransferDTO transferDTO) {
        if (!card.getPan().equals(transferDTO.getSource()))
            throw new InvalidCardInfoException();
        if (!card.getCvv2().equals(transferDTO.getCvv2()))
            throw new InvalidCardInfoException();
        if (!card.getExpireDate().equals(transferDTO.getExpireDate()))
            throw new InvalidCardInfoException();
        if (DateUtil.convertExpireDate(card.getExpireDate()).isBefore(LocalDate.now()))
            throw new InvalidCardInfoException();
        if (!card.getPassword().equals(transferDTO.getPassword()))
            throw new InvalidCardInfoException();
    }

    private void validateMerchant(CardEntity card, Long merchantId) {
        if (!card.getMerchant().getId().equals(merchantId))
            throw new UnauthorizedException();
    }
}

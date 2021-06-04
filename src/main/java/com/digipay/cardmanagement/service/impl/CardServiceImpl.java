package com.digipay.cardmanagement.service.impl;

import com.digipay.cardmanagement.dto.CardDTO;
import com.digipay.cardmanagement.entity.CardEntity;
import com.digipay.cardmanagement.exception.CardNotFoundException;
import com.digipay.cardmanagement.exception.UnauthorizedException;
import com.digipay.cardmanagement.mapper.CardMapper;
import com.digipay.cardmanagement.mapper.MerchantMapper;
import com.digipay.cardmanagement.repository.CardRepository;
import com.digipay.cardmanagement.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final MerchantMapper merchantMapper;

    @Override
    public CardDTO createCard(Long merchantId, CardDTO cardDTO) {
        CardEntity card = cardMapper.toEntity(cardDTO);
        card.setMerchant(merchantMapper.fromId(merchantId));
        card.setActive(true);
        card.setCreateDate(Instant.now());
        return cardMapper.toDto(cardRepository.save(card));
    }

    @Override
    public Page<CardDTO> getMerchantCards(Long merchantId, Pageable pageable) {
        return cardRepository.findAllByMerchantIdAndActiveIsTrue(merchantId, pageable)
                .map(cardMapper::toDto);
    }

    @Override
    public void softDelete(Long merchantId, Long cardId) {
        CardEntity card = cardRepository.findById(cardId).orElseThrow(CardNotFoundException::new);
        if (!card.getMerchant().getId().equals(merchantId))
            throw new UnauthorizedException();
        card.setActive(false);
        cardRepository.save(card);
    }
}

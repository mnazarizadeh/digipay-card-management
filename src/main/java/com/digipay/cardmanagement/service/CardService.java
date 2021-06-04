package com.digipay.cardmanagement.service;

import com.digipay.cardmanagement.dto.CardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService {

    CardDTO createCard(Long merchantId, CardDTO cardDTO);

    Page<CardDTO> getMerchantCards(Long merchantId, Pageable pageable);

    void softDelete(Long merchantId, Long cardId);

}

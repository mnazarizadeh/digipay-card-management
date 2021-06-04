package com.digipay.cardmanagement.service;

import com.digipay.cardmanagement.dto.CardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService {

    /**
     * create a card for merchant which requested for it
     *
     * @param merchantId    the ID of merchant calling the action
     * @param cardDTO       the card properties
     * @return              a card which is created
     */
    CardDTO createCard(Long merchantId, CardDTO cardDTO);

    /**
     * get merchant cards with pagination
     *
     * @param merchantId    the ID of merchant calling the action
     * @param pageable      pagination properties
     * @return              a page of cards
     */
    Page<CardDTO> getMerchantCards(Long merchantId, Pageable pageable);

    /**
     * deactivate a card of merchant
     * @param merchantId    the ID of merchant calling the action
     * @param cardId        the ID of card to be deactivated
     */
    void softDelete(Long merchantId, Long cardId);

}

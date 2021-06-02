package com.digipay.cardmanagement.controller;

import com.digipay.cardmanagement.dto.CardDTO;
import com.digipay.cardmanagement.exception.IdExistsException;
import com.digipay.cardmanagement.service.CardService;
import com.digipay.cardmanagement.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class CardController {

    private final CardService cardService;

    @PostMapping("/cards")
    public ResponseEntity<CardDTO> createCard(@RequestHeader(value = "merchantId") Long merchantId,
                                              @RequestBody CardDTO cardDTO) throws URISyntaxException {
        log.debug("REST request to save new card : {}", cardDTO);
        if (cardDTO.getId() != null) {
            throw new IdExistsException();
        }


        CardDTO result = cardService.createCard(merchantId, cardDTO);

        return ResponseEntity
                .created(new URI("/api/card/" + result.getId()))
                .body(result);
    }

    @GetMapping("/cards")
    public ResponseEntity<?> getAllOrganizations(@RequestHeader(value = "merchantId") Long merchantId,
                                                 Pageable pageable) {
        log.debug("REST request to get a page of cards for merchantId : {}", merchantId);

        Page<CardDTO> page = cardService.getMerchantCards(merchantId, pageable);
        return ResponseEntity.ok()
                .headers(PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page))
                .body(page.getContent());
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Void> deleteCards(@RequestHeader(value = "merchantId") Long merchantId,
                                            @PathVariable Long id) {
        log.debug("REST request to delete card : {}", id);
        cardService.softDelete(merchantId, id);
        return ResponseEntity.noContent().build();
    }

}

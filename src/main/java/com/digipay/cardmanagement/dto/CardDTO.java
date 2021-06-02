package com.digipay.cardmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDTO {

    private Long id;
    private String pan;
    private String cvv2;
    private LocalDate createDate;
    private LocalDate expireDate;
    private String pin;
    private String password;
    private Double deposit;
    private MerchantDTO merchant;
    private Set<TransactionDTO> transactions = new HashSet<>();
}

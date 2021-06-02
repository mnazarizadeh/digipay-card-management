package com.digipay.cardmanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDTO {

    private Long id;
    private String pan;
    private String cvv2;
    private Instant createDate;
    private String expireDate;
    private String pin;
    private String password;
    private Boolean active;
    @JsonIgnoreProperties(value = "cards")
    private MerchantDTO merchant;
    private Set<TransactionDTO> transactions = new HashSet<>();
}

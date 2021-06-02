package com.digipay.cardmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDTO {

    private Long id;

    @NotNull
    @Length(min = 16, max = 19)
    private String pan;

    @NotNull
    @Length(max = 4)
    private String cvv2;

    private Instant createDate;

    @NotNull
    @Length(min = 5, max = 5)
    private String expireDate;

    @NotNull
    @Length(min = 4, max = 4)
    private String pin;

    @NotNull
    @Length(min = 5)
    private String password;

    private Boolean active;

    @JsonIgnoreProperties(value = "cards")
    private MerchantDTO merchant;

    private Set<TransactionDTO> transactions = new HashSet<>();
}

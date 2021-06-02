package com.digipay.cardmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    @JsonIgnoreProperties(value = "merchant")
    private Set<CardDTO> cards = new HashSet<>();

}

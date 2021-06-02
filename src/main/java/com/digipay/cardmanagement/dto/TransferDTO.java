package com.digipay.cardmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferDTO {

    private String source;
    private String destination;
    private String expireDate;
    private String cvv2;
    private Double amount;
    private String password;
}

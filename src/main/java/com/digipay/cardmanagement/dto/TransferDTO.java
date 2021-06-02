package com.digipay.cardmanagement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferDTO {

    @NotNull
    @Length(min = 16, max = 19)
    private String source;
    @NotNull
    @Length(min = 16, max = 19)
    private String destination;
    @NotNull
    @Length(min = 5, max = 5)
    private String expireDate;
    @NotNull
    @Length(max = 4)
    private String cvv2;
    @NotNull
    @Positive
    private Double amount;
    @NotNull
    private String password;
}

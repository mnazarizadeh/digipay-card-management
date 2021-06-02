package com.digipay.cardmanagement.dto;

import com.digipay.cardmanagement.entity.CardEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {

    private Long id;
    private String source;
    private String destination;
    private Double amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTransaction;
    private Boolean verified;

}

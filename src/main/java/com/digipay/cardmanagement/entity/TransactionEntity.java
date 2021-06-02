package com.digipay.cardmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBTransaction")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    @JsonIgnoreProperties(value = "cards")
    private CardEntity source;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "start_transaction", nullable = false)
    private Instant startTransaction;

    @Column(name = "verified", nullable = false, columnDefinition = "boolean default false")
    private Boolean verified;
}

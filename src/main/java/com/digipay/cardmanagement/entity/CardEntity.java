package com.digipay.cardmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBCard")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pan", nullable = false, unique = true)
    private String pan;

    @Column(name = "cvv2", nullable = false)
    private String cvv2;

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Column(name = "expire_date", nullable = false)
    private String expireDate;

    @Column(name = "pin", nullable = false)
    private String pin;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false, columnDefinition = "boolean default true")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    @JsonIgnoreProperties(value = "cards")
    private MerchantEntity merchant;

    @ToString.Exclude
    @OneToMany(mappedBy = "source", fetch = FetchType.LAZY)
    private Set<TransactionEntity> transactions = new HashSet<>();

    public String getBin() {
        if (pan == null || pan.length() < 16)
            return null;
        return pan.substring(0,6);
    }
}

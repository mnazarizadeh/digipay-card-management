package com.digipay.cardmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TBMerchant")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MerchantEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @ToString.Exclude
    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY)
    private Set<CardEntity> cards = new HashSet<>();

}

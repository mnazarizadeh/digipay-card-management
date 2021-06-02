package com.digipay.cardmanagement.repository;

import com.digipay.cardmanagement.entity.CardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    Page<CardEntity> findAllByMerchantIdAndActiveIsTrue(Long merchantId, Pageable pageable);

    Optional<CardEntity> findByPanAndActiveIsTrue(String source);
}

package com.digipay.cardmanagement.repository;

import com.digipay.cardmanagement.entity.CardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {

    Page<CardEntity> findAllByMerchantIdAndActiveIsTrue(Long merchantId, Pageable pageable);
}
package com.digipay.cardmanagement.repository;

import com.digipay.cardmanagement.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    Page<TransactionEntity> findBySourceMerchantIdAndVerifiedIsTrue(Long merchantId, Pageable pageable);
}

package com.digipay.cardmanagement.repository;

import com.digipay.cardmanagement.entity.CardEntity;
import com.digipay.cardmanagement.entity.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {
}

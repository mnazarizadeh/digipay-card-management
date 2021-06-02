package com.digipay.cardmanagement.mapper;

import com.digipay.cardmanagement.dto.CardDTO;
import com.digipay.cardmanagement.entity.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring", uses = {TransactionMapper.class, MerchantMapper.class}, imports = {Instant.class})
public interface CardMapper {

    CardEntity toEntity(CardDTO dto);

    CardDTO toDto(CardEntity entity);

}

package com.digipay.cardmanagement.mapper;

import com.digipay.cardmanagement.dto.TransactionDTO;
import com.digipay.cardmanagement.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring", uses = {CardMapper.class})
public interface TransactionMapper {

    @Mapping(source = "source", target = "source.pan")
    TransactionEntity toEntity(TransactionDTO dto);

    @Mapping(source = "source.pan", target = "source")
    TransactionDTO toDto(TransactionEntity entity);

}

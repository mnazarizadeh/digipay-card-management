package com.digipay.cardmanagement.mapper;

import com.digipay.cardmanagement.dto.CardDTO;
import com.digipay.cardmanagement.dto.MerchantDTO;
import com.digipay.cardmanagement.entity.CardEntity;
import com.digipay.cardmanagement.entity.MerchantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring", uses = {CardMapper.class}, imports = {Instant.class})
public interface MerchantMapper {

    MerchantEntity toEntity(MerchantDTO dto);

    @Mapping(target = "cards", ignore = true)
    MerchantDTO toDto(MerchantEntity entity);

    default MerchantEntity fromId(Long id) {
        if (id == null) {
            return null;
        }
        MerchantEntity obj = new MerchantEntity();
        obj.setId(id);
        return obj;
    }
}

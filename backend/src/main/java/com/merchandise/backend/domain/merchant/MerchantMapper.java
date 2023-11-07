package com.merchandise.backend.domain.merchant;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MerchantMapper {

    public MerchantEntity inDtoToEntity(MerchantInDto merchantInDto) {
        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setName(merchantInDto.getName());
        merchantEntity.setEmail(merchantInDto.getEmail());
        merchantEntity.setPhoneNumber(merchantInDto.getPhoneNumber());
        merchantEntity.setAddress(merchantInDto.getAddress());
        merchantEntity.setCity(merchantInDto.getCity());
        merchantEntity.setState(merchantInDto.getState());
        merchantEntity.setPinCode(merchantInDto.getPinCode());
        merchantEntity.setUpiID(merchantInDto.getUpiId());
        merchantEntity.setMerchantRole(merchantInDto.getMerchantRole());
        return merchantEntity;
    }

    public MerchantOutDto entityToOutDto(MerchantEntity merchantEntity) {
        MerchantOutDto merchantOutDto = new MerchantOutDto();
        merchantOutDto.setMerchantId(merchantEntity.getId());
        merchantOutDto.setName(merchantEntity.getName());
        merchantOutDto.setEmail(merchantEntity.getEmail());
        merchantOutDto.setPhoneNumber(merchantEntity.getPhoneNumber());
        merchantOutDto.setAddress(merchantEntity.getAddress());
        merchantOutDto.setCity(merchantEntity.getCity());
        merchantOutDto.setState(merchantEntity.getState());
        merchantOutDto.setPinCode(merchantEntity.getPinCode());
        merchantOutDto.setUpiId(merchantEntity.getUpiID());
        merchantOutDto.setMerchantRole(merchantEntity.getMerchantRole());
        return merchantOutDto;
    }

    public MerchantEntity inDtoToExistingEntity(MerchantInDto merchantInDto, MerchantEntity merchantEntity) {
        merchantEntity.setName(merchantInDto.getName());
        merchantEntity.setEmail(merchantInDto.getEmail());
        merchantEntity.setPhoneNumber(merchantInDto.getPhoneNumber());
        merchantEntity.setAddress(merchantInDto.getAddress());
        merchantEntity.setCity(merchantInDto.getCity());
        merchantEntity.setState(merchantInDto.getState());
        merchantEntity.setPinCode(merchantInDto.getPinCode());
        merchantEntity.setUpiID(merchantInDto.getUpiId());
        merchantEntity.setMerchantRole(merchantInDto.getMerchantRole());
        return merchantEntity;
    }

    public List<MerchantOutDto> entitiesToOutDtos(List<MerchantEntity> merchantEntities) {
        return merchantEntities.stream()
                .map(this::entityToOutDto)
                .toList();
    }
}

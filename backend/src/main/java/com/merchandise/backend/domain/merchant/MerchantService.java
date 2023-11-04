package com.merchandise.backend.domain.merchant;

import com.merchandise.backend.domain.product.ProductOutDto;

import java.util.List;

public interface MerchantService {
    List<MerchantOutDto> findAll();

    List<ProductOutDto> findAllByMerchantId(Long merchantId);

    MerchantOutDto findOne(Long id);

    MerchantOutDto create(MerchantInDto merchantInDto);

    MerchantOutDto update(MerchantInDto merchantInDto, Long id);

    void delete(Long id);
}

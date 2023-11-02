package com.merchandise.backend.domain.merchant;

import java.util.List;

public interface MerchantService {
    List<MerchantOutDto> findAll();

    MerchantOutDto findOne(Long id);

    MerchantOutDto create(MerchantInDto merchantInDto);

    MerchantOutDto update(MerchantInDto merchantInDto, Long id);

    void delete(Long id);
}

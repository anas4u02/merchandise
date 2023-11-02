package com.merchandise.backend.domain.merchant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepo merchantRepo;
    private final MerchantMapper merchantMapper;

    @Override
    public List<MerchantOutDto> findAll() {
        List<MerchantEntity> merchantEntities = merchantRepo.findAll();
        return merchantMapper.entitiesToOutDtos(merchantEntities);
    }

    @Override
    public MerchantOutDto findOne(Long id) {
        MerchantEntity merchantEntity = this.getMerchant(id);
        return merchantMapper.entityToOutDto(merchantEntity);
    }

    @Override
    public MerchantOutDto create(MerchantInDto merchantInDto) {
        MerchantEntity merchantEntity = merchantMapper.inDtoToEntity(merchantInDto);
        merchantRepo.save(merchantEntity);
        return merchantMapper.entityToOutDto(merchantEntity);
    }

    @Override
    public MerchantOutDto update(MerchantInDto merchantInDto, Long id) {
        MerchantEntity merchantEntity = this.getMerchant(id);
        merchantEntity = merchantMapper.inDtoToExistingEntity(merchantInDto, merchantEntity);
        merchantRepo.save(merchantEntity);
        return merchantMapper.entityToOutDto(merchantEntity);
    }

    @Override
    public void delete(Long id) {
        MerchantEntity merchantEntity = this.getMerchant(id);
        merchantRepo.delete(merchantEntity);
    }

    private MerchantEntity getMerchant(Long id) {
        return merchantRepo.findById(id)
                .orElseThrow(() -> new MerchantNotFoundException("Merchant with id: " + id + " not found!"));
    }
}

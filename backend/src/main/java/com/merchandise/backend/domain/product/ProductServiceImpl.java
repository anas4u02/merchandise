package com.merchandise.backend.domain.product;

import com.merchandise.backend.domain.category.CategoryEntity;
import com.merchandise.backend.domain.category.CategoryNotFoundException;
import com.merchandise.backend.domain.category.CategoryRepo;
import com.merchandise.backend.domain.merchant.MerchantEntity;
import com.merchandise.backend.domain.merchant.MerchantNotFoundException;
import com.merchandise.backend.domain.merchant.MerchantRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ProductMapper productMapper;
    private final MerchantRepo merchantRepo;

    public ProductServiceImpl(ProductRepo productRepo,
                              CategoryRepo categoryRepo,
                              ProductMapper productMapper,
                              MerchantRepo merchantRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.productMapper = productMapper;
        this.merchantRepo = merchantRepo;
    }

    @Override
    public List<ProductOutDto> findAll() {
        List<ProductEntity> productEntities = productRepo.findAll();
        return productMapper.entitiesToOutDtos(productEntities);
    }

    @Override
    public ProductOutDto findOne(Long id) {
        ProductEntity productEntity = getProductEntity(id);
        return productMapper.entityToOutDto(productEntity);
    }

    //    Note: The creation, Update and delete APIs are not to be used in FE. For superuser purpose
    @Override
    public ProductOutDto create(ProductInDto productInDto) {
        CategoryEntity categoryEntity = getCategoryEntity(productInDto);
        MerchantEntity merchantEntity = getMerchantEntity(productInDto);
        ProductEntity productEntity = productMapper.inDtoToEntity(productInDto, categoryEntity, merchantEntity);
        productRepo.save(productEntity);
        return productMapper.entityToOutDto(productEntity);
    }

    @Override
    public ProductOutDto update(ProductInDto productInDto, Long id) {
        CategoryEntity categoryEntity = getCategoryEntity(productInDto);
        MerchantEntity merchantEntity = getMerchantEntity(productInDto);
        ProductEntity productEntity = getProductEntity(id);
        productEntity = productMapper.inDtoToExistingEntity(productInDto, categoryEntity, merchantEntity, productEntity);
        productRepo.save(productEntity);
        return productMapper.entityToOutDto(productEntity);
    }

    @Override
    public void delete(Long id) {
        ProductEntity productEntity = this.getProductEntity(id);
        productRepo.delete(productEntity);
    }

    private CategoryEntity getCategoryEntity(ProductInDto productInDto) {
        Long categoryId = productInDto.getCategoryId();
        return categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id: " + categoryId + " not found"));
    }

    private ProductEntity getProductEntity(Long id) {
        return productRepo.findById(id).
                orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " not found!"));
    }

    private MerchantEntity getMerchantEntity(ProductInDto productInDto) {
        Long merchantId = productInDto.getMerchantId();
        return merchantRepo.findById(merchantId).
                orElseThrow(() -> new MerchantNotFoundException("Merchant with id : " + merchantId + " not found!"));
    }
}

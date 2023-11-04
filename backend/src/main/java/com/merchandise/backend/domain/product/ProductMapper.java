package com.merchandise.backend.domain.product;

import com.merchandise.backend.domain.category.CategoryEntity;
import com.merchandise.backend.domain.merchant.MerchantEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductEntity inDtoToEntity(ProductInDto productInDto, CategoryEntity categoryEntity, MerchantEntity merchantEntity) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategoryEntity(categoryEntity);
        productEntity.setMerchantEntity(merchantEntity);
        productEntity.setName(productInDto.getProductName());
        productEntity.setDescription(productInDto.getDescription());
        productEntity.setStockQuantity(productInDto.getStockQuantity());
        productEntity.setPrice(productInDto.getPrice());
        productEntity.setImageUrl(productInDto.getImageUrl());
        return productEntity;
    }

    public ProductOutDto entityToOutDto(ProductEntity productEntity) {
        ProductOutDto productOutDto = new ProductOutDto();
        productOutDto.setProductId(productEntity.getId());
        productOutDto.setProductName(productEntity.getName());
        productOutDto.setDescription(productEntity.getDescription());
        productOutDto.setStockQuantity(productEntity.getStockQuantity());
        productOutDto.setPrice(productEntity.getPrice());
        productOutDto.setImageUrl(productEntity.getImageUrl());
        productOutDto.setCategoryId(productEntity.getCategoryEntity().getId());
        productOutDto.setMerchantId(productEntity.getMerchantEntity().getId());
        return productOutDto;
    }

    public List<ProductOutDto> entitiesToOutDtos(List<ProductEntity> productEntities) {
        return productEntities.stream().map(this::entityToOutDto).toList();
    }

    public ProductEntity inDtoToExistingEntity(ProductInDto productInDto, CategoryEntity
            categoryEntity, MerchantEntity merchantEntity, ProductEntity productEntity) {
        productEntity.setName(productInDto.getProductName());
        productEntity.setDescription(productInDto.getDescription());
        productEntity.setStockQuantity(productInDto.getStockQuantity());
        productEntity.setPrice(productInDto.getPrice());
        productEntity.setImageUrl(productInDto.getImageUrl());
        productEntity.setCategoryEntity(categoryEntity);
        productEntity.setMerchantEntity(merchantEntity);
        return productEntity;
    }
}

package com.merchandise.backend.domain.product;

import com.merchandise.backend.domain.category.CategoryEntity;

import java.util.List;

public class ProductMapper {

    public ProductEntity inDtoToEntity(ProductInDto productInDto, CategoryEntity categoryEntity) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategoryEntity(categoryEntity);
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
        return productOutDto;
    }

    public List<ProductOutDto> entitiesToOutDtos(List<ProductEntity> productEntities) {
        return productEntities.stream().map(this::entityToOutDto).toList();
    }

    public ProductEntity inDtoToExistingEntity(ProductInDto productInDto, CategoryEntity
            categoryEntity, ProductEntity productEntity) {
        productEntity.setName(productInDto.getProductName());
        productEntity.setDescription(productInDto.getDescription());
        productEntity.setStockQuantity(productInDto.getStockQuantity());
        productEntity.setPrice(productInDto.getPrice());
        productEntity.setImageUrl(productInDto.getImageUrl());
        productEntity.setCategoryEntity(categoryEntity);
        return productEntity;
    }
}

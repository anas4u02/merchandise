package com.merchandise.backend.domain.product;

import com.merchandise.backend.domain.category.CategoryEntity;
import com.merchandise.backend.domain.category.CategoryNotFoundException;
import com.merchandise.backend.domain.category.CategoryRepo;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.productMapper = productMapper;
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

    @Override
    public ProductOutDto create(ProductInDto productInDto) {
        CategoryEntity categoryEntity = getCategoryEntity(productInDto);
        ProductEntity productEntity = productMapper.inDtoToEntity(productInDto, categoryEntity);
        productRepo.save(productEntity);
        return productMapper.entityToOutDto(productEntity);
    }

    @Override
    public ProductOutDto update(ProductInDto productInDto, Long id) {
        CategoryEntity categoryEntity = getCategoryEntity(productInDto);
        ProductEntity productEntity = getProductEntity(id);
        productEntity = productMapper.inDtoToExistingEntity(productInDto, categoryEntity, productEntity);
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
}

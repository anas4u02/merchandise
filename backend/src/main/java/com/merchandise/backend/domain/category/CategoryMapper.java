package com.merchandise.backend.domain.category;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {

    CategoryEntity inDtoToEntity(CategoryInDto categoryInDto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryInDto.getCategoryName());
        return categoryEntity;
    }

    CategoryOutDto entityToOutDto(CategoryEntity categoryEntity) {
        CategoryOutDto categoryOutDto = new CategoryOutDto();
        categoryOutDto.setCategoryId(categoryEntity.getId());
        categoryOutDto.setCategoryName(categoryEntity.getCategoryName());
        return categoryOutDto;
    }

    CategoryEntity inDtoToExistingEntity(CategoryInDto categoryInDto, CategoryEntity categoryEntity) {
        categoryEntity.setCategoryName(categoryInDto.getCategoryName());
        return categoryEntity;
    }

    List<CategoryOutDto> inDtosToOutDtos(List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream().map(this::entityToOutDto).toList();
    }
}

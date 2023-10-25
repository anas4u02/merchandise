package com.merchandise.backend.domain.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryOutDto> findAll() {
        List<CategoryEntity> categoryEntities = categoryRepo.findAll();
        return categoryMapper.inDtosToOutDtos(categoryEntities);
    }

    @Override
    public CategoryOutDto findOne(Long id) {
        CategoryEntity categoryEntity = this.getCategory(id);
        return categoryMapper.entityToOutDto(categoryEntity);
    }

    @Override
    public CategoryOutDto create(CategoryInDto categoryInDto) {
        CategoryEntity categoryEntity = categoryMapper.inDtoToEntity(categoryInDto);
        categoryRepo.save(categoryEntity);
        return categoryMapper.entityToOutDto(categoryEntity);
    }

    @Override
    public CategoryOutDto update(Long id, CategoryInDto categoryInDto) {
        CategoryEntity categoryEntity = this.getCategory(id);
        categoryEntity = categoryMapper.inDtoToExistingEntity(categoryInDto, categoryEntity);
        categoryRepo.save(categoryEntity);
        return categoryMapper.entityToOutDto(categoryEntity);
    }

    @Override
    public void delete(Long id) {
        CategoryEntity categoryEntity = this.getCategory(id);
        categoryRepo.delete(categoryEntity);
    }

    private CategoryEntity getCategory(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with " + id + " not found!"));
    }
}

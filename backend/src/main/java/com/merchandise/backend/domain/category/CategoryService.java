package com.merchandise.backend.domain.category;

import java.util.List;

public interface CategoryService {

    List<CategoryOutDto> findAll();

    CategoryOutDto findOne(Long id);

    CategoryOutDto create(CategoryInDto categoryInDto);

    CategoryOutDto update(Long id, CategoryInDto categoryInDto);

    void delete(Long id);
}

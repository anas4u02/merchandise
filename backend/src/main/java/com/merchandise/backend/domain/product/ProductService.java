package com.merchandise.backend.domain.product;

import java.util.List;

public interface ProductService {

    List<ProductOutDto> findAll();

    ProductOutDto findOne(Long id);

    ProductOutDto create(ProductInDto productInDto);

    ProductOutDto update(ProductInDto productInDto, Long id);

    void delete(Long id);
}

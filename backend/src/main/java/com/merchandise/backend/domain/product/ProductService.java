package com.merchandise.backend.domain.product;

import java.util.List;

public interface ProductService {

    public List<ProductOutDto> findAll();

    public ProductOutDto findOne(Long id);

    public ProductOutDto create(ProductInDto productInDto);

    public ProductOutDto update(ProductInDto productInDto, Long id);

    public void delete(Long id);
}

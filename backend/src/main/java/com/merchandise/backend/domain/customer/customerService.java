package com.merchandise.backend.domain.customer;

import java.util.List;

public interface customerService {
    List<CustomerOutDto> findAll();

    CustomerOutDto findOne(Long id);

    CustomerOutDto create(CustomerInDto customerInDto);

    CustomerOutDto update(Long id, CustomerInDto customerInDto);

    void delete(Long id);
}

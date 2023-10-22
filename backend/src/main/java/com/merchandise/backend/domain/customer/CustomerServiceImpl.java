package com.merchandise.backend.domain.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerOutDto> findAll() {
        List<CustomerEntity> customerEntities = customerRepo.findAll();
        return customerMapper.customerEntitiesToOutDtos(customerEntities);
    }

    @Override
    public CustomerOutDto findOne(Long id) {
        CustomerEntity customerEntity = getCustomerEntity(id);
        return customerMapper.customerEntityToOutDto(customerEntity);
    }

    @Override
    public CustomerOutDto create(CustomerInDto customerInDto) {
        CustomerEntity customerEntity = customerMapper.customerInDtoToEntity(customerInDto);
        customerRepo.save(customerEntity);
        return customerMapper.customerEntityToOutDto(customerEntity);
    }

    @Override
    public CustomerOutDto update(Long id, CustomerInDto customerInDto) {
        CustomerEntity customerEntity = this.getCustomerEntity(id);
        customerEntity = customerMapper.inDtoToExistingEntity(customerInDto, customerEntity);
        customerRepo.save(customerEntity);
        return customerMapper.customerEntityToOutDto(customerEntity);
    }

    @Override
    public void delete(Long id) {
        CustomerEntity customerEntity = this.getCustomerEntity(id);
        customerRepo.delete(customerEntity);
    }

    private CustomerEntity getCustomerEntity(Long id) {
        return customerRepo.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("Customer with " + id + " not found!"));
    }
}

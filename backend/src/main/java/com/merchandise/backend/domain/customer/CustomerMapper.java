package com.merchandise.backend.domain.customer;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {

    public CustomerEntity customerInDtoToEntity(CustomerInDto customerInDto) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerInDto.getFirstName());
        customerEntity.setLastName(customerInDto.getLastName());
        customerEntity.setPhoneNumber(customerInDto.getPhoneNumber());
        customerEntity.setGender(customerInDto.getGender());
        customerEntity.setEmail(customerInDto.getEmail());
        customerEntity.setAddress(customerInDto.getAddress());
        customerEntity.setCity(customerInDto.getCity());
        customerEntity.setPinCode(customerInDto.getPinCode());
        customerEntity.setState(customerInDto.getState());
        customerEntity.setCountry(customerInDto.getCountry());
        return customerEntity;
    }

    public CustomerOutDto customerEntityToOutDto(CustomerEntity customerEntity) {
        CustomerOutDto customerOutDto = new CustomerOutDto();
        customerOutDto.setFirstName(customerEntity.getFirstName());
        customerOutDto.setLastName(customerEntity.getLastName());
        customerOutDto.setPhoneNumber(customerEntity.getPhoneNumber());
        customerOutDto.setGender(customerEntity.getGender());
        customerOutDto.setEmail(customerEntity.getEmail());
        customerOutDto.setAddress(customerEntity.getAddress());
        customerOutDto.setCity(customerEntity.getCity());
        customerOutDto.setPinCode(customerEntity.getPinCode());
        customerOutDto.setState(customerEntity.getState());
        customerOutDto.setCountry(customerEntity.getCountry());
        return customerOutDto;
    }

    public List<CustomerOutDto> customerEntitiesToOutDtos(List<CustomerEntity> customerEntities) {
        return customerEntities.stream().map(this::customerEntityToOutDto).toList();
    }

    public CustomerEntity inDtoToExistingEntity(CustomerInDto customerInDto, CustomerEntity customerEntity) {
        customerEntity.setFirstName(customerInDto.getFirstName());
        customerEntity.setLastName(customerInDto.getLastName());
        customerEntity.setPhoneNumber(customerInDto.getPhoneNumber());
        customerEntity.setGender(customerInDto.getGender());
        customerEntity.setEmail(customerInDto.getEmail());
        customerEntity.setAddress(customerInDto.getAddress());
        customerEntity.setCity(customerInDto.getCity());
        customerEntity.setPinCode(customerInDto.getPinCode());
        customerEntity.setState(customerInDto.getState());
        customerEntity.setCountry(customerInDto.getCountry());
        return customerEntity;
    }
}

package com.merchandise.backend.domain.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOutDto> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerOutDto findOne(@PathVariable("id") Long id) {
        return customerService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerOutDto create(@RequestBody CustomerInDto customerInDto) {
        return customerService.create(customerInDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerOutDto update(@PathVariable("id") Long id, @RequestBody CustomerInDto customerInDto) {
        return customerService.update(id, customerInDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id) {
        customerService.delete(id);
    }
}

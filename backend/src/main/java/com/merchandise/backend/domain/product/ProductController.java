package com.merchandise.backend.domain.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productService = productServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOutDto> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductOutDto findOne(@PathVariable("id") Long id) {
        return productService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductOutDto create(@RequestBody ProductInDto productInDto) {
        return productService.create(productInDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ProductOutDto update(@PathVariable("id") Long id, @RequestBody ProductInDto productInDto) {
        return productService.update(productInDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}

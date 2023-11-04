package com.merchandise.backend.domain.merchant;

import com.merchandise.backend.domain.product.ProductInDto;
import com.merchandise.backend.domain.product.ProductOutDto;
import com.merchandise.backend.domain.product.ProductService;
import com.merchandise.backend.domain.product.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchant/{merchantId}/products")
public class MerchantProductController {
    private final ProductService productService;
    private final MerchantService merchantService;

    public MerchantProductController(ProductServiceImpl productServiceImpl, MerchantServiceImpl merchantServiceImpl) {
        this.merchantService = merchantServiceImpl;
        this.productService = productServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOutDto> findAllProductsByMerchant(@PathVariable("merchantId") Long merchantId) {
        return merchantService.findAllProductsByMerchantId(merchantId);
    }

    @GetMapping("/{productId}")
    public ProductOutDto findOneProductByMerchantId(@PathVariable("productId") Long productId,
                                                    @PathVariable("merchantId") Long merchantId) {
        return merchantService.findOneProductByMerchantId(merchantId, productId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductOutDto addProduct(@PathVariable("merchantId") Long merchantId,
                                    @RequestBody ProductInDto productInDto) {
        productInDto.setMerchantId(merchantId);
        return productService.create(productInDto);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductOutDto updateProduct(@PathVariable("productId") Long productId,
                                       @RequestBody ProductInDto productInDto) {
        return productService.update(productInDto, productId);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void removeProduct(@PathVariable("productId") Long productId) {
        productService.delete(productId);
    }
}

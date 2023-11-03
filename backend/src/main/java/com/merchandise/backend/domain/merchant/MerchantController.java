package com.merchandise.backend.domain.merchant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantServiceImpl merchantServiceImpl) {
        this.merchantService = merchantServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MerchantOutDto> findAll() {
        return merchantService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantOutDto findOne(@PathVariable("id") Long id) {
        return merchantService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MerchantOutDto create(@RequestBody MerchantInDto merchantInDto) {
        return merchantService.create(merchantInDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MerchantOutDto update(@RequestBody MerchantInDto merchantInDto,
                                 @PathVariable("id") Long id) {
        return merchantService.update(merchantInDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id) {
        merchantService.delete(id);
    }
}

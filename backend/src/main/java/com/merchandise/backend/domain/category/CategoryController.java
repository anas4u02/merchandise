package com.merchandise.backend.domain.category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryService = categoryServiceImpl;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryOutDto> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryOutDto findOne(@PathVariable("id") Long id) {
        return categoryService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryOutDto create(@RequestBody CategoryInDto categoryInDto) {
        return categoryService.create(categoryInDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryOutDto update(@RequestBody CategoryInDto categoryInDto, @PathVariable("id") Long id) {
        return categoryService.update(id, categoryInDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }
}

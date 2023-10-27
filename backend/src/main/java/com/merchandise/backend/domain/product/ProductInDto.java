package com.merchandise.backend.domain.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductInDto {
    String productName;
    String description;
    Long stockQuantity;
    Float price;
    String imageUrl;
    Long categoryId;
}

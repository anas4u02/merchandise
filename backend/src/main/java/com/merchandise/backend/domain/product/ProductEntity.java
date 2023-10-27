package com.merchandise.backend.domain.product;

import com.merchandise.backend.domain.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String description;

    Long stockQuantity;

    Float price;

    String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    CategoryEntity categoryEntity;
}

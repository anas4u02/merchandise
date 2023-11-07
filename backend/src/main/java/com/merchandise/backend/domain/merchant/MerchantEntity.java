package com.merchandise.backend.domain.merchant;

import com.merchandise.backend.domain.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "merchant")
public class MerchantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String address;

    private String city;

    private String state;

    private String pinCode;

    private String phoneNumber;

    private String upiID;

    private Boolean merchantRole;

    @OneToMany(mappedBy = "merchantEntity", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities = new ArrayList<>();
}

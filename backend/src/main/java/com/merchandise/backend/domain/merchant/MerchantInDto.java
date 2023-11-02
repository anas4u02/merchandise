package com.merchandise.backend.domain.merchant;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MerchantInDto {
    String name;
    String email;
    String phoneNumber;
    String address;
    String city;
    String state;
    String pinCode;
    String upiId;
}

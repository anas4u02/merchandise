package com.merchandise.backend.domain.merchant;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MerchantOutDto {
    Long merchantId;
    String name;
    String email;
    String phoneNumber;
    String address;
    String city;
    String state;
    String pinCode;
    String upiId;
    Boolean merchantRole;
}

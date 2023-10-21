package com.merchandise.backend.domain.customer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class customerInDto {
    Long customerId;
    String firstName;
    String lastName;
    String email;
    String gender;
    String phoneNumber;
    String address;
    String city;
    String pinCode;
    String state;
    String country;
}

package com.rin.ecommerce.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CustomerResponse {
    String id;
    String firstname;
    String lastname;
    String email;
    Address address;
}

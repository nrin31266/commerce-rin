package com.rin.ecommerce.customer;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
    @NotNull(message = "Customer fist name is required")
    String firstname;
    @NotNull(message = "Customer last name is required")
    String lastname;
    @NotNull(message = "Customer email is not valid email address")
    String email;
    Address address;
}

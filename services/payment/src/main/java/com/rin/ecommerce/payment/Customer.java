package com.rin.ecommerce.payment;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    String id;
    @NotNull(message = "Firstname is required")
    String firstname;
    @NotNull(message = "Lastname is required")
    String lastname;
    @NotNull(message = "Email is required")
    @Email(message = "The customer is not correctly formatted")
    String email;
}

package com.rin.ecommerce.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Slf4j
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    String street;
    String houseNumber;
    String zipCode;

}

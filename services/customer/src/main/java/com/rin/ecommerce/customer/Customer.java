package com.rin.ecommerce.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    @MongoId
    String id;
    String firstname;
    String lastname;
    String email;
    Address address;
}

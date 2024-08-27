package com.rin.ecommerce.kafka.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    Integer productId;
    String name;
    String description;
    BigDecimal price;
    double quantity;
}

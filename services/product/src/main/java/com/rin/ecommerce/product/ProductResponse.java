package com.rin.ecommerce.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Integer id;
    String name;
    String description;
    double availableQuantity;
    BigDecimal price;
    Integer categoryId;
    String categoryName;
    String categoryDescription;
}

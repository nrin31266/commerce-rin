package com.rin.ecommerce.product;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPurchaseResponse {
    Integer productId;
    String name;
    String description;
    BigDecimal price;
    double quantity;
}

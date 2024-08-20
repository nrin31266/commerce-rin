package com.rin.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
    Integer id;
    @NotNull(message = "Product name is required")
    String name;
    @NotNull(message = "Product description is required")
    String description;
    @Positive(message = "Available quantity should be position")
    double availableQuantity;
    @Positive(message = "Price should be position")
    BigDecimal price;
    @NotNull(message = "Category id is required")
    Integer categoryId;
}

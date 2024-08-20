package com.rin.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPurchaseRequest {
    @NotNull(message = "Product is mandatory")
    Integer productId;
    @NotNull(message = "Quantity is mandatory")
    double quantity;
}

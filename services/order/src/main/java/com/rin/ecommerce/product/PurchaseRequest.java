package com.rin.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRequest {
    @NotNull(message = "Product is mandatory")
    Integer productId;
    @Positive(message = "Quantity is mandatory")
    double quantity;
}

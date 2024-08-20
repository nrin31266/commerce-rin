package com.rin.ecommerce.orderline;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderLineRequest {
    Integer id;
    Integer orderId;
    Integer productId;
    double quantity;
}

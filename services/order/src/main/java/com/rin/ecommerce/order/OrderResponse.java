package com.rin.ecommerce.order;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    Integer id;
    String reference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerId;
}

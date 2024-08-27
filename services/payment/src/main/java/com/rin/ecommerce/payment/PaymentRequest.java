package com.rin.ecommerce.payment;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    Integer id;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    Integer orderId;
    String orderReference;
    Customer customer;
}

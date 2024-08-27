package com.rin.ecommerce.payment;

import com.rin.ecommerce.customer.CustomerResponse;
import com.rin.ecommerce.order.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequest {
    BigDecimal amount;
    PaymentMethod paymentMethod;
    Integer orderId;
    String orderReference;
    CustomerResponse customer;
}

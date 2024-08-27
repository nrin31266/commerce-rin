package com.rin.ecommerce.kafka;

import com.rin.ecommerce.customer.CustomerResponse;
import com.rin.ecommerce.order.PaymentMethod;
import com.rin.ecommerce.product.PurchaseResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderConfirmation {
    String orderReference;
    BigDecimal totalAmount;
    PaymentMethod paymentMethod;
    CustomerResponse customer;
    List<PurchaseResponse> products;
}

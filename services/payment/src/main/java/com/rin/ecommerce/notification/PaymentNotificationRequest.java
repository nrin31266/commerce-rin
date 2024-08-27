package com.rin.ecommerce.notification;

import com.rin.ecommerce.payment.PaymentMethod;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentNotificationRequest {
    String orderReference;
    BigDecimal amount;
    PaymentMethod paymentMethod;
    String customerFirstname;
    String customerLastname;
    String customerEmail;
}

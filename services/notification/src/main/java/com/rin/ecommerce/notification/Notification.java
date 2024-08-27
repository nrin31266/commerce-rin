package com.rin.ecommerce.notification;

import com.rin.ecommerce.kafka.order.OrderConfirmation;
import com.rin.ecommerce.kafka.payment.PaymentConfirmation;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {
    @Id
    String id;

    NotificationType type;
    LocalDateTime notificationDate;
    OrderConfirmation orderConfirmation;
    PaymentConfirmation paymentConfirmation;
}

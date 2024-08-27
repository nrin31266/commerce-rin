package com.rin.ecommerce.payment;

import com.rin.ecommerce.notification.NotificationProducer;
import com.rin.ecommerce.notification.PaymentNotificationRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentService {
    PaymentRepository paymentRepository;
    PaymentMapper paymentMapper;
    NotificationProducer notificationProducer;

    public Integer createPayment(PaymentRequest req) {
        var payment = paymentRepository.save(paymentMapper.toPayment(req));
        notificationProducer.sendNotification(
                PaymentNotificationRequest.builder()
                        .orderReference(req.getOrderReference())
                        .paymentMethod(req.getPaymentMethod())
                        .amount(req.getAmount())
                        .customerFirstname(req.getCustomer().getFirstname())
                        .customerLastname(req.getCustomer().getLastname())
                        .customerEmail(req.getCustomer().getEmail())
                        .build()
        );

        return payment.getId();
    }
}

package com.rin.ecommerce.order;

import com.rin.ecommerce.customer.CustomerClient;
import com.rin.ecommerce.exception.BusinessException;
import com.rin.ecommerce.kafka.OrderConfirmation;
import com.rin.ecommerce.kafka.OrderProducer;
import com.rin.ecommerce.orderline.OrderLine;
import com.rin.ecommerce.orderline.OrderLineRequest;
import com.rin.ecommerce.orderline.OrderLineService;
import com.rin.ecommerce.payment.PaymentClient;
import com.rin.ecommerce.payment.PaymentRequest;
import com.rin.ecommerce.product.ProductClient;
import com.rin.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {
    OrderRepository orderRepository;
    CustomerClient customerClient;
    ProductClient productClient;
    OrderMapper orderMapper;
    OrderLineService orderLineService;
    OrderProducer orderProducer;
    PaymentClient paymentClient;

    public Integer createOrder(OrderRequest request) {
        // check the customer --> OpenFeign
        var customer = customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided Id"));
        // purchase the products --> product-ms (RestTemplate)
        var purchaseProducts = productClient.purchaseProduct(request.getProducts());
        // persist order
        var order = orderRepository.save(orderMapper.toOrder(request));

        //persist order lines
        for (PurchaseRequest purchaseRequest : request.getProducts()) {
            orderLineService.saveOrderLine(
                    OrderLineRequest.builder()
                            .id(null)
                            .orderId(order.getId())
                            .productId(purchaseRequest.getProductId())
                            .quantity(purchaseRequest.getQuantity())
                            .build()
            );
        }
        // todo start payment process
        paymentClient.requestOrderPayment(PaymentRequest.builder()
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .orderId(order.getId())
                .orderReference(order.getReference())
                .customer(customer)
                .build());

        // send the order confirmation --> notification-ms (kafka)
        orderProducer.sendOrderConfirmation(
                OrderConfirmation.builder()
                        .orderReference(request.getReference())
                        .totalAmount(request.getAmount())
                        .paymentMethod(request.getPaymentMethod())
                        .customer(customer)
                        .products(purchaseProducts)
                        .build()
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::toOrderResponse).toList();
    }

    public OrderResponse findById(Integer orderId) {
        return orderMapper.toOrderResponse(orderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No order found with provided ID: %d,", orderId))));
    }
}

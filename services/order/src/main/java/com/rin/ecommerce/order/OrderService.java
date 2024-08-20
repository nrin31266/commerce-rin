package com.rin.ecommerce.order;

import com.rin.ecommerce.customer.CustomerClient;
import com.rin.ecommerce.exception.BusinessException;
import com.rin.ecommerce.orderline.OrderLine;
import com.rin.ecommerce.orderline.OrderLineRequest;
import com.rin.ecommerce.orderline.OrderLineService;
import com.rin.ecommerce.product.ProductClient;
import com.rin.ecommerce.product.PurchaseRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {
    OrderRepository orderRepository;
    CustomerClient customerClient;
    ProductClient productClient;
    OrderMapper orderMapper;
    OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        // check the customer --> OpenFeign
        var customer = customerClient.findCustomerById(request.getCustomerId())
                .orElseThrow(()->new BusinessException("Cannot create order:: No customer exists with the provided Id"));
        // purchase the products --> product-ms (RestTemplate)
        productClient.purchaseProduct(request.getProducts());
        // persist order
        var order = orderRepository.save(orderMapper.toOrder(request));

        //persist order lines
        for (PurchaseRequest purchaseRequest: request.getProducts()){
            orderLineService.saveOrderLine(
                    OrderLineRequest.builder()
                            .id(null)
                            .orderId(order.getId())
                            .productId(purchaseRequest.getProductId())
                            .quantity(purchaseRequest.getQuantity())
                            .build()
            );
        }
        //start payment process

        //send the order confirmation --> notification-ms (kafka)
        return null;
    }
}

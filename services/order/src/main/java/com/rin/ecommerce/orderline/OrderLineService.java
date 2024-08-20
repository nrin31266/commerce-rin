package com.rin.ecommerce.orderline;

import com.rin.ecommerce.order.Order;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderLineService {
    OrderLineRepository orderLineRepository;
    OrderLineMapper orderLineMapper;

    public Integer saveOrderLine(OrderLineRequest request) {
        var order = orderLineMapper.toOrderLine(request);
        order.setOrder(
                Order.builder()
                        .id(request.getOrderId())
                        .build()
        );
        return orderLineRepository.save(order).getId();
    }
}

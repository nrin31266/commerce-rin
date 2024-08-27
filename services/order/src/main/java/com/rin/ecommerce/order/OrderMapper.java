package com.rin.ecommerce.order;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper{
    Order toOrder(OrderRequest request);

    OrderResponse toOrderResponse(Order order);
}

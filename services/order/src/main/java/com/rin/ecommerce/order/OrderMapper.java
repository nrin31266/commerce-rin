package com.rin.ecommerce.order;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper{
    Order toOrder(OrderRequest request);
}

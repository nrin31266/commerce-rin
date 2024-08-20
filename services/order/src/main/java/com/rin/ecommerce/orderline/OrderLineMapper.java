package com.rin.ecommerce.orderline;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {
    @Mapping(target = "order", ignore = true)
    OrderLine toOrderLine(OrderLineRequest request);
}

package com.rin.ecommerce.payment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toPayment(PaymentRequest request);
}

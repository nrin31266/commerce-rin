package com.rin.ecommerce.customer;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerRequest request);
    void customerUpdate(@MappingTarget Customer customer, CustomerRequest request);
    CustomerResponse toCustomerResponse(Customer customer);

}

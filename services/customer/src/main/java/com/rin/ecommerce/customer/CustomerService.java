package com.rin.ecommerce.customer;

import com.rin.ecommerce.exception.CustomerNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public CustomerResponse createCustomer(CustomerRequest request) {
        log.info("Request: {}", request);
        Customer customer = customerMapper.toCustomer(request);
        customer = customerRepository.save(customer);
        log.info("Customer: {}", customer);
        return customerMapper.toCustomerResponse(customer);
    }

    public void updateCustomer(String customerId, CustomerRequest request) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: Customer with id %s not found::", customerId)
                ));
        customerMapper.customerUpdate(customer, request);
        customerRepository.save(customer);

    }

    public List<CustomerResponse> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::toCustomerResponse).toList();
    }

    public Boolean existsById(String customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return customerMapper.toCustomerResponse(customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(format("No customer with id %s found::", customerId))));
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}

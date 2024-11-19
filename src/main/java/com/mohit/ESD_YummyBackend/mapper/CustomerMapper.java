package com.mohit.ESD_YummyBackend.mapper;

import com.mohit.ESD_YummyBackend.dto.CustomerRequest;
import com.mohit.ESD_YummyBackend.dto.CustomerResponse;
import com.mohit.ESD_YummyBackend.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .address(request.address())
                .city(request.city())
                .pincode(request.pincode())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress(),  // Include address
                customer.getCity(),     // Include city
                customer.getPincode()
        );
    }
}
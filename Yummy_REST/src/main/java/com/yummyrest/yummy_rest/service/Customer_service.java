package com.yummyrest.yummy_rest.service;

import com.yummyrest.yummy_rest.dto.Customer_request;
import com.yummyrest.yummy_rest.dto.Customer_response;
import com.yummyrest.yummy_rest.entity.Customer;
import com.yummyrest.yummy_rest.helper.EncryptionService;
import com.yummyrest.yummy_rest.mapper.Customer_mapper;
import com.yummyrest.yummy_rest.repo.Customer_repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class Customer_service {
    private final Customer_repo repo;
    private final Customer_mapper mapper;
    private final EncryptionService encryptionService;

    public String createCustomer(Customer_request request) {
        Customer customer = mapper.toCustomer(request);
        customer.setPassword(encrytionService.encode(customer.getPassword()));
        repo.save(customer);
        return "Customer Created";
    }
    public Customer getCustomer(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(format("No Customer found with provided email:%s",email)));
    }

    public Customer_response retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return mapper.toCustomerResponse(customer);

    }
}

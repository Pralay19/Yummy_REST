package com.yummyrest.yummy_rest.service;

import com.yummyrest.yummy_rest.dto.Customer_request;
import com.yummyrest.yummy_rest.entity.Customer;
import com.yummyrest.yummy_rest.mapper.Customer_mapper;
import com.yummyrest.yummy_rest.repo.Customer_repo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class Customer_service {
    private final Customer_repo repo;
    private final Customer_mapper mapper;

    public String createCustomer(Customer_request request) {
        Customer customer = mapper.toCustomer(request);
        repo.save(customer);
        return "Customer Created";
    }
}

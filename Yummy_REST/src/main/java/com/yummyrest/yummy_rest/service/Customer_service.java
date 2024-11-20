package com.yummyrest.yummy_rest.service;

import com.yummyrest.yummy_rest.dto.Customer_request;
import com.yummyrest.yummy_rest.dto.Customer_response;

import com.yummyrest.yummy_rest.dto.Login_request;
import com.yummyrest.yummy_rest.entity.Customer;
import com.yummyrest.yummy_rest.helper.EncryptionService;
import com.yummyrest.yummy_rest.helper.JWTHelper;
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
    private final JWTHelper jwtHelper;

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
    public String updateCustomer(CustomerUpdateRequest customerUpdateRequest, String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        String email = jwtHelper.extractEmail(token);
        Customer customer = getCustomer(email);
        if(customerUpdateRequest.firstName() != null)
            customer.setFirstName(customerUpdateRequest.firstName());
        if(customerUpdateRequest.lastName() != null)
            customer.setLastName(customerUpdateRequest.lastName());
        repo.save(customer);
        return "Customer updated";
    }

    public String loginCustomer(Login_request request) {
        Customer customer = getCustomer(request.email());
        if(!encryptionService.validates(request.password(), customer.getPassword())) {
            return "Incorrect email or password";
        }
        return jwtHelper.generateToken(request.email());
    }

    public Customer_response retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return mapper.toCustomerResponse(customer);

    }

}

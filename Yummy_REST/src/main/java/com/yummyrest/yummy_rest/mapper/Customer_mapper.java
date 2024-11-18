package com.yummyrest.yummy_rest.mapper;


import com.yummyrest.yummy_rest.dto.Customer_request;
import com.yummyrest.yummy_rest.dto.Customer_response;
import com.yummyrest.yummy_rest.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class Customer_mapper {
    public Customer toCustomer(Customer_request request){

        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }
    public Customer_response toCustomerResponse(Customer customer){
        return new Customer_response( customer.getFirstName(),customer.getLastName(),customer.getEmail());
    }
}

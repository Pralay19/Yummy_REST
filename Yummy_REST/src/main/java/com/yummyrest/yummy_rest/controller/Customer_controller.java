package com.yummyrest.yummy_rest.controller;


import com.yummyrest.yummy_rest.dto.Customer_request;
import com.yummyrest.yummy_rest.service.Customer_service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class Customer_controller {
    private final Customer_service customer_service;
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid Customer_request request) {
        return ResponseEntity.ok(customer_service.createCustomer(request));
    }
}

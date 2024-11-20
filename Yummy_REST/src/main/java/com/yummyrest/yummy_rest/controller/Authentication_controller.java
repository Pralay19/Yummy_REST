package com.yummyrest.yummy_rest.controller;

import com.yummyrest.yummy_rest.dto.Login_request;
import com.yummyrest.yummy_rest.entity.Customer;
import com.yummyrest.yummy_rest.service.Customer_service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class Authentication_controller {
    private final Customer_service customerService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login_request request) {
    return ResponseEntity.ok(customerService.loginCustomer(request));
    }

}

package com.yummyrest.yummy_rest.controller;


import com.yummyrest.yummy_rest.dto.Customer_request;
import com.yummyrest.yummy_rest.dto.Customer_response;
import com.yummyrest.yummy_rest.helper.JWTHelper;
import com.yummyrest.yummy_rest.service.Customer_service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class Customer_controller {
    private final Customer_service customer_service;
    private final JWTHelper jwtHelper;

    @GetMapping("/{email}")
    public ResponseEntity<Customer_response> get_email(@PathVariable("email") String email, HttpServletRequest request) {
        if(!jwtHelper.validateAuthorizationHeader(request.getHeader("Authorization"))){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(customer_service.retrieveCustomer(email));
    }


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid Customer_request request) {
        return ResponseEntity.ok(customer_service.createCustomer(request));
    }

    @PatchMapping
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid CustomerUpdateRequest customerUpdateRequest, HttpServletRequest request) {
        if(!jwtHelper.validateAuthorizationHeader(request.getHeader("Authorization"))){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.ok(customerService.updateCustomer(customerUpdateRequest, request.getHeader("Authorization")));
    }
}

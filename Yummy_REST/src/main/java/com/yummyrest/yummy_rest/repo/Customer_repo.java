package com.yummyrest.yummy_rest.repo;

import com.yummyrest.yummy_rest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Customer_repo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
    List<Customer> findByLastName(String lastName);
}

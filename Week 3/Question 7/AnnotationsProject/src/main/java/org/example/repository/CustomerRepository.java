package org.example.repository;

import org.example.model.Customer;

import java.util.Optional;

public interface CustomerRepository {
    public Optional<Customer> findById(int id);
}

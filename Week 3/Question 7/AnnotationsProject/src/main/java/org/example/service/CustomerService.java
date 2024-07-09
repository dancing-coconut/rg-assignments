package org.example.service;

import org.example.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.model.Customer;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepositoryImpl customerRepository;

    @Autowired
    public CustomerService(CustomerRepositoryImpl customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findCustomerById(int id) {
        return customerRepository.findById(id);
    }

}

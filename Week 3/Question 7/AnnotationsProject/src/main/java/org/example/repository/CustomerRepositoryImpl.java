package org.example.repository;

import org.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public CustomerRepositoryImpl() {
        customers.add(new Customer(1, "John Doe"));
        customers.add(new Customer(2, "Jane Smith"));
    }


    @Override
    public Optional<Customer> findById(int id) {
        return customers.stream().filter(customer -> customer.getId() == id).findFirst();
    }

}

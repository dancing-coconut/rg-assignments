package com.example.customerbatch.config;

import com.example.customerbatch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public  Customer process(Customer customer) throws Exception {
        return customer;
    }
}

package org.example.controller;

import org.example.component.CheckingComponent;
import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final CheckingComponent checkingComponent;

    @Autowired
    public CustomerController(CustomerService customerService, CheckingComponent checkingComponent) {
        this.customerService = customerService;
        this.checkingComponent = checkingComponent;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String getUserById(@PathVariable int id) {
        Optional<Customer> customerOptional = customerService.findCustomerById(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            boolean isLucky = checkingComponent.check(id);
            return "Customer name: " + customer.getName() + ". Lucky: " + isLucky;
        } else {
            return "Customer not found";
        }
    }


}

package com.example.employeecrud.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee emp1 = new Employee(
                1,
                "Employee 1",
                "Department 1"
            );

            Employee emp2 = new Employee(
              2,
              "Employee 2",
              "Department 2"
            );

            repository.saveAll(List.of(emp1, emp2));
        };
    }
}

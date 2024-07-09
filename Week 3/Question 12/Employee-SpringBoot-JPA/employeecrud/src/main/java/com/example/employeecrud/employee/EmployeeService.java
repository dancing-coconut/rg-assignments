package com.example.employeecrud.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        System.out.println(employee);
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("No Employee with given ID: " + employeeId);
        }
        employeeRepository.deleteById(employeeId);
    }

    @Transactional
    public void updateEmployee(Integer employeeId, String name, String department) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("No Employee with ID: " + employeeId));
        if (name != null &&
                !name.isEmpty() &&
                !Objects.equals(employee.getName(), name)) {
            employee.setName(name);
        }
        if (department != null &&
                !department.isEmpty() &&
                !Objects.equals(employee.getDepartment(), department)) {
            employee.setDepartment(department);
        }
    }
}

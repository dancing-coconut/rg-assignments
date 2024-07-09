package org.example;

import org.example.dao.EmployeeDAOImpl;
import org.example.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeCRUD {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application Context Loaded!");

        EmployeeDAOImpl employeeDAOImpl =  context.getBean("employeeDao", EmployeeDAOImpl.class);

        // CREATE (C)
        Employee employee1 = new Employee(1, "Employee 1", "Department 1");
        Employee employee2 = new Employee(2, "Employee 3", "Department 3");
        int rowsInsertedCount1 = employeeDAOImpl.insert(employee1);
        System.out.println(rowsInsertedCount1 + " row(s) inserted.");
        int rowsInsertedCount2 = employeeDAOImpl.insert(employee2);
        System.out.println(rowsInsertedCount2 + " row(s) inserted.");

        // READ (R)
        List<Employee> employees = employeeDAOImpl.select();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // UPDATE (U)
        int rowsUpdatedCount = employeeDAOImpl.update(2, "Employee 2", "Department 2");
        System.out.println(rowsUpdatedCount + " row(s) updated.");

        // DELETE (D)
        int rowsDeletedCount = employeeDAOImpl.delete(2);
        System.out.println(rowsDeletedCount + "row(s) deleted.");
    }
}
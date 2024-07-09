package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public int insert(Employee employee);

    public List<Employee> select();

    public int update(int id, String name, String department);

    public int delete(int id);
}

package org.example.dao;

import org.example.model.Employee;
import org.example.model.EmployeeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Employee employee) {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?);";
        Object[] args = {employee.getId(), employee.getName(), employee.getDepartment()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public List<Employee> select() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public int update(int id, String name, String department) {
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?;";
        Object[] args = {name, department, id};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM employees WHERE id = ?;";
        Object[] args = {id};
        return jdbcTemplate.update(sql, args);
    }
}

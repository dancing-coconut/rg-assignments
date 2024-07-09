package org.example.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Employee(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("department")
        );
    }
}

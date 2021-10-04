package com.example.restservicemetpostgresql.service;

import com.example.restservicemetpostgresql.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(long id);
    List<Employee> findAll();
    void create(Employee employee);
    void update(Employee employee);
    void delete(long id);

}

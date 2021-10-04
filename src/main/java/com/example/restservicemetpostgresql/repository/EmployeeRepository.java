package com.example.restservicemetpostgresql.repository;

import com.example.restservicemetpostgresql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

package com.example.restservicemetpostgresql.controller;

import com.example.restservicemetpostgresql.model.Employee;
import com.example.restservicemetpostgresql.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("{id}")
    Employee get(@PathVariable long id){
        return employeeService.findById(id).get();
    }
}

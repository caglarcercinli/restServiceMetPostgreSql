package com.example.restservicemetpostgresql.controller;

import com.example.restservicemetpostgresql.exception.EmployeeNietGevondenException;
import com.example.restservicemetpostgresql.model.Employee;
import com.example.restservicemetpostgresql.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("{id}")
    Employee get(@PathVariable long id){
        return employeeService.findById(id)
                .orElseThrow(EmployeeNietGevondenException::new);
    }
    @ExceptionHandler(EmployeeNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void EmployeeNietGevonden() {
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable long id) {
        employeeService.delete(id);
    }
    @PostMapping
    void post(@RequestBody Employee employee) {
        employeeService.create(employee);
    }


}

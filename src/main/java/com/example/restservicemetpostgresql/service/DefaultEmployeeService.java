package com.example.restservicemetpostgresql.service;

import com.example.restservicemetpostgresql.exception.EmployeeNietGevondenException;
import com.example.restservicemetpostgresql.model.Employee;
import com.example.restservicemetpostgresql.repository.EmployeeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultEmployeeService implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public DefaultEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    //@Transactional(readOnly = true)
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    //@Transactional(readOnly = true)
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        try{
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmployeeNietGevondenException();
        }
    }
}

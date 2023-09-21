package com.coffeehause.web.services;

import com.coffeehause.web.entity.Employee;
import com.coffeehause.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired private EmployeeRepository repository;
    public List<Employee> listAll(){
        return repository.findAll();
    }
}

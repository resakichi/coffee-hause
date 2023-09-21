package com.coffeehause.web.controller;

import com.coffeehause.web.entity.Employee;
import com.coffeehause.web.repository.EmployeeRepository;
import com.coffeehause.web.repository.RoleRepository;
import com.coffeehause.web.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired private EmployeeService service;
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    EmployeeController(EmployeeRepository employeeRepository, RoleRepository roleRepository){
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/employ/save")
    public String createEmpl(Map<String, Object> model){
        model.put("employee", new Employee());
//        model.put("role", new Role());
        model.put("roleList", roleRepository.findAll());
        return "main.html";
    }
    @PostMapping("/employ/create")
    public String createEmploy(Employee employee){
        System.out.println(employee.toString());
        employee.setRole(roleRepository.getById(employee.getRole().getRole_id()));
        employeeRepository.save(employee);
        return "redirect:/";
    }
    @GetMapping("/employ")
    List<Employee> all(){return employeeRepository.findAll();}

    @GetMapping("/employees")
    public String showEmployees(Map<String, Object> model){
        model.put("listEmployee",service.listAll());
        return "employees.html";
    }
}

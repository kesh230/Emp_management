package com.manage.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.emp.entity.Employee;
import com.manage.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    // private PasswordEncoder passwordEncoder;
    
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addemployee(Employee emp1){
        return this.employeeRepository.save(emp1);
    }
    
}

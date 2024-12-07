package com.manage.emp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.manage.emp.entity.Employee;
import com.manage.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public Employee addemployee(Employee emp1){
        emp1.setPassword(this.passwordEncoder.encode(emp1.getPassword()));
        return this.employeeRepository.save(emp1);
    }

    public Optional<Employee> get_by_empid(int emp_id) {
         Optional<Employee> emp=this.employeeRepository.findByEmployeeId(emp_id);
         return emp;
    }
    
}

package com.manage.emp.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.emp.entity.Employee;
import com.manage.emp.service.EmployeeService;

@RestController
@RequestMapping("/company/it")
public class IT_Controller {
    
    private EmployeeService employeeService;

    public IT_Controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
   
     @GetMapping("/get/{id}")
    public ResponseEntity<?> get_sales_data_by_id(@PathVariable("id") Integer emp_id){
        Optional<Employee> emp=this.employeeService.get_by_empid(emp_id);
        return ResponseEntity.of(emp);
        
    }
    
}

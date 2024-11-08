package com.manage.emp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manage.emp.entity.Employee;
import com.manage.emp.repository.EmployeeRepository;


@Service
public class UserDetailService implements UserDetailsService {

    private EmployeeRepository employeeRepository;

    
    @Autowired
    public UserDetailService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee=this.employeeRepository.getEmployeeByEmail(username);
        if(employee.isEmpty()){
            throw new UsernameNotFoundException("USER does not exit");
        }
        Employee emp= employee.get();

        return User.builder().username(emp.getEmail())
                   .password(emp.getPassword()).roles(emp.getDepartment()).build();
            
    }


    
}

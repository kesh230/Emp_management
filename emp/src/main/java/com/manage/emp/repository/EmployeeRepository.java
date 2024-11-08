package com.manage.emp.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manage.emp.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,UUID> {
    public Optional<Employee> getEmployeeByEmail(String email);
}

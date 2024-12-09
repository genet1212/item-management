package com.backend.service;

import com.backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getByUserName(String userName);
}

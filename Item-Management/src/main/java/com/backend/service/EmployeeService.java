package com.backend.service;

import com.backend.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getByFirstName(String firstName);
    Employee createEmployee(Employee employee);
    Employee getEmployee(Long id);
    Employee updateEmployee(Long id, Employee employee);
    Employee deleteEmployee(Long id, Employee employee);
}

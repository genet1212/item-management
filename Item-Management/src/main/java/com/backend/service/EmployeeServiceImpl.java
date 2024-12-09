package com.backend.service;

import com.backend.model.Employee;
import com.backend.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> emps = new ArrayList<>();
         emps = employeeRepository.findAll();
        System.out.println("Emp: " + emps.toString());
        return emps;
    }

    @Override
    public Employee getByUserName(String userName) {
        return employeeRepository.findByUserName(userName);
    }
}

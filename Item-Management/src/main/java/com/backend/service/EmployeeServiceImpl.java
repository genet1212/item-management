package com.backend.service;

import com.backend.model.Employee;
import com.backend.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.backend.utils.Utils.getNullPropertyNames;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        List<Employee> emps = new ArrayList<>();
         emps = employeeRepository.findAll();
        System.out.println("Emp: " + emps.toString());
        return emps;
    }

    @Override
    public Employee getByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Employee with an id: " + id + "was not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).get();
        BeanUtils.copyProperties(employee, existingEmployee, getNullPropertyNames(employee));
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Employee deleteEmployee(Long id, Employee employee) {
        return employeeRepository.save(employee);
    }

}

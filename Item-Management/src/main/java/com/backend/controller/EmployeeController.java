package com.backend.controller;

import com.backend.model.Employee;
import com.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/query")
    public Employee getEmployeeByFirstName(@RequestParam(name = "firstName")String firstName){
      return employeeService.getByFirstName(firstName);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable(name="id") Long id, @RequestBody Employee employee) {
       return employeeService.updateEmployee(id, employee);
    }
    @DeleteMapping("{id}")
    public Employee deleteEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return employeeService.deleteEmployee(id, employee);
    }

}

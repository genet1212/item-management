package com.backend.controller;

import com.backend.model.Employee;
import com.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping
    public Employee getEmployeeByUserName(@RequestParam(name = "userName")String userName){
      return employeeService.getByUserName(userName);
    }

}

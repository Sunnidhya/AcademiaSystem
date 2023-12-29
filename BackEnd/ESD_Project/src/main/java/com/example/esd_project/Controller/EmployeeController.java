package com.example.esd_project.Controller;

import com.example.esd_project.Entities.Employee;
import com.example.esd_project.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin
    @PostMapping("/login")
    public String login(@RequestBody Employee employee) {
        Employee employeeVal = employeeService.authenticate(employee);
        if(employeeVal != null){
            return "Login Successful";
        }else {
            return "Login is not successful";
        }
    }

    @CrossOrigin
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllUsers(){
        return employeeService.getAll();
    }
}

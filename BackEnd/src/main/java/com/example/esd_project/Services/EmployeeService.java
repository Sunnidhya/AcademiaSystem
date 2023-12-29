package com.example.esd_project.Services;

import com.example.esd_project.Entities.Employee;
import com.example.esd_project.Repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    public Employee authenticate(Employee employee) {
        try {
            return iEmployeeRepository.findByEmailAndPassword(employee.getEmployeeName() , employee.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iEmployeeRepository.findByEmailAndPassword(employee.getEmployeeName() , employee.getPassword());
    }

    public List<Employee> getAll(){
        try {
            return iEmployeeRepository.getAllUserLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iEmployeeRepository.getAllUserLogin();
    }
}

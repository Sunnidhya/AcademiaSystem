package com.example.esd_project.Repository;

import com.example.esd_project.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Serializable> {

    @Query("SELECT e FROM Employee e JOIN Department d on e.department.departmentId = d.departmentId where e.employeeName = :username AND e.password = :password AND d.departmentId =1")
    Employee findByEmailAndPassword(@Param("username") String userName, @Param("password") String password);

    @Query("select e from Employee e")
    List<Employee> getAllUserLogin();
}

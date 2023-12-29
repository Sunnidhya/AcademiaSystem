package com.example.esd_project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(nullable = false)
    private String employeeName;

    @Column(nullable = false, unique = true)
    private String email;

    private String title;

    private String photographPath;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @JsonIgnore
    private Department department;
}

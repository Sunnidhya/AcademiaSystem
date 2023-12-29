package com.example.esd_project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;

}

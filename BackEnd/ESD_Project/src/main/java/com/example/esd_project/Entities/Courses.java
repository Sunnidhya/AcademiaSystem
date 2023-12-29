package com.example.esd_project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column(nullable = false,unique = true)
    private String courseCode;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Double credits;

    @Column(nullable = false)
    private Integer capacity;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Student> students;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Specialization> specializations;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Domain> domains;
}

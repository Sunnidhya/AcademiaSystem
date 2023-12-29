package com.example.esd_project.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false, unique = true)
    private Integer studentRollNo;

    @Column(nullable = false, unique = true)
    private String email;

    private String photographPath;

    @Column(nullable = false)
    private Double cgpa=0.0;

    @Column(nullable = false)
    private Double totalCredits;

    @Column(nullable = false)
    private Long graduationYear;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Student_Courses",  joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
               inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))
    @JsonIgnore
    private Set<Courses> courses;

    @ManyToOne
    @JoinColumn(name = "domain_id")
    @JsonIgnore
    private Domain domain;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
}

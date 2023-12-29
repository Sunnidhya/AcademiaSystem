package com.example.esd_project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specializationId;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Double creditsRequired;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Specialization_Course",  joinColumns = @JoinColumn(name = "specialization_id", referencedColumnName = "specializationId"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))
    @JsonIgnore
    private Set<Courses> courses;

    @OneToMany(mappedBy = "specialization")
    @JsonIgnore
    private List<Student> students;
}

package com.example.esd_project.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domainId;

    @Column(nullable = false)
    private String program;

    @Column(nullable = false)
    private String batch;

    @Column(nullable = false)
    private Integer capacity;

    private String qualification;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Course_Domain",  joinColumns = @JoinColumn(name = "domain_id", referencedColumnName = "domainId"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"))
    @JsonIgnore
    private Set<Courses> courses;

    @OneToMany(mappedBy = "domain")
    @JsonIgnore
    private List<Student> students;
}

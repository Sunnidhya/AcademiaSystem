package com.example.esd_project.Controller;

import com.example.esd_project.Entities.Domain;
import com.example.esd_project.Entities.Specialization;
import com.example.esd_project.Entities.Student;
import com.example.esd_project.Model.SpecializationCreditsDTO;
import com.example.esd_project.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @CrossOrigin

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> allStudents = studentService.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/student/specialization")
    public ResponseEntity<List<String>> getAllStudentSpecialization(){
        return new ResponseEntity<>(studentService.getAllStudentsSpecialization(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/student/domain")
    public ResponseEntity<List<Student>> getAllStudentByDomain(@RequestBody Domain domain){
        return new ResponseEntity<> (studentService.getAllStudentsByDomain(domain.getDomainId()), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/student/studentBySpecialization")
    public ResponseEntity<List<SpecializationCreditsDTO>> getAllStudentBySpecialization(@RequestBody Specialization specialization){
        List<Object[]> result = studentService.getAllStudentsBySpecialization(specialization.getSpecializationId());
        List<SpecializationCreditsDTO> data = new ArrayList<>();

        for(Object[] res: result){
            SpecializationCreditsDTO cusRes = new SpecializationCreditsDTO();
            cusRes.setStudentId((Integer) res[0]);
            cusRes.setStudentName((String) res[1]);
            cusRes.setName((String) res[2]);
            cusRes.setCredits((Double) res[3]);
            data.add(cusRes);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

}

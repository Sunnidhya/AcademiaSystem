package com.example.esd_project.Services;

import com.example.esd_project.Entities.Student;
import com.example.esd_project.Model.SpecializationCreditsDTO;
import com.example.esd_project.Repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService{

    @Autowired
    private IStudentRepository iStudentRepository;

    public List<Student> getAllStudents() {
        return iStudentRepository.getAllStudent();
    }

    public List<String > getAllStudentsSpecialization() { return iStudentRepository.getAllStudentsSpecialization();}

    public List<Student> getAllStudentsByDomain(Integer id) {
        return iStudentRepository.getStudentByDomain(id);}

    public List<Object[]> getAllStudentsBySpecialization(Integer id) {
        return iStudentRepository.getStudentBySpecialization(id);
    }
}

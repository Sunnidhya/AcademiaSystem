package com.example.esd_project.Repository;

import com.example.esd_project.Entities.Student;
import com.example.esd_project.Model.SpecializationCreditsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Serializable> {

    @Query("SELECT distinct sp.name FROM Student s JOIN Specialization sp on s.specialization.specializationId = sp.specializationId ")
    List<String> getAllStudentsSpecialization();

    @Query("select s from Student s")
    List<Student> getAllStudent();

    @Query("SELECT s FROM Student s JOIN Domain d on s.domain.domainId = d.domainId where d.domainId =?1 order by s.studentId")
    List<Student> getStudentByDomain(Integer id);

    @Query("SELECT s.studentId, s.studentName, sp.name, SUM(c.credits) as credits  FROM Student s JOIN s.courses c JOIN c.specializations sp where s.specialization.specializationId=?1 group by s.studentId,sp.name,s.studentName having SUM(c.credits)>20 order by s.studentId")
    List<Object[]> getStudentBySpecialization(Integer id);
}

package com.springMySQL.repository;
import java.lang.Integer;
import java.util.List;

import com.springMySQL.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // get student by student name
    List<Student> findByStudentName(String studentName);
}

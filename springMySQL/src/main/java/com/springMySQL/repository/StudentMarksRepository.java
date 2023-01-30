package com.springMySQL.repository;

import java.lang.Integer;
import java.util.List;

import com.springMySQL.entity.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Integer> {
    // get student marks by student id
    List<StudentMarks> findByStudentId(int studentId);
}

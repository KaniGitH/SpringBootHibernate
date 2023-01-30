package com.springMySQL.service;

import com.springMySQL.entity.StudentMarks;
import com.springMySQL.repository.StudentMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMarksService {
    @Autowired
    private StudentMarksRepository repository;

    public List<StudentMarks> saveStudentMarks(List<StudentMarks> studentsMarks) {
        // save all student marks
        return repository.saveAll(studentsMarks);
    }

    public void updateStudentMarks(StudentMarks studentMarks) {
        // get existing student marks by student mark id
        StudentMarks existingStudentMarks = repository.findById(studentMarks.getStudentMarkId()).orElse(null);
        // update marks
        existingStudentMarks.setStudentMark1(studentMarks.getStudentMark1());
        existingStudentMarks.setStudentMark2(studentMarks.getStudentMark2());
        existingStudentMarks.setStudentMark3(studentMarks.getStudentMark3());
        existingStudentMarks.setStudentMark4(studentMarks.getStudentMark4());
        existingStudentMarks.setStudentMark5(studentMarks.getStudentMark5());
        // update total marks
        existingStudentMarks.setTotalMarks(existingStudentMarks.getStuTotalMarks(existingStudentMarks));
        // save updated changes
        repository.save(existingStudentMarks);
    }

    public void deleteStudentMarksByStudentId(int studentId) {
        //get all student marks by student id
        List<StudentMarks> studentMarks = repository.findByStudentId(studentId);
        // delete each student marks by student mark id
        for (StudentMarks stuMark : studentMarks) {
            repository.deleteById(stuMark.getStudentMarkId());
        }
    }

}

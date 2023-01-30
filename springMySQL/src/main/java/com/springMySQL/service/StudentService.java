package com.springMySQL.service;

import java.util.List;

import com.springMySQL.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springMySQL.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        // save student detail
        return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        // save all students detail
        return repository.saveAll(students);
    }

    public List<Student> getStudents() {
        // get all students detail
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        // get student detail by student id
        return repository.findById(id).orElse(null);
    }

    public List<Student> getStudentByName(String studentName) {
        // get student detail by student name
        return repository.findByStudentName(studentName);
    }

    public String deleteStudentById(int studentId) {
        // delete student by student id
        repository.deleteById(studentId);
        return "Student Id - " + studentId + " is deleted";
    }

    public Student updateStudent(Student student) {

        // get existing student
        Student existingStudent = repository.findById(student.getStudentId()).orElse(null);
        // update all fields of student
        existingStudent.setStudentRollNo(student.getStudentRollNo());
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentGrade(student.getStudentGrade());
        existingStudent.setStudentSection(student.getStudentSection());
        // save updated changes
        return repository.save(existingStudent);
    }

}

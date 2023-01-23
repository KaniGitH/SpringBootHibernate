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

        return repository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return repository.saveAll(students);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> getStudentByName(String studentName) {
        return repository.findByStudentName(studentName);
    }

    public String deleteStudentById(int studentId)
    {
        repository.deleteById(studentId);
        return "Student Id - "+studentId+" is deleted";
    }

    public Student updateStudent(Student student)
    {
        Student existingStudent=repository.findById(student.getStudentId()).orElse(null);
        existingStudent.setStudentRollNo(student.getStudentRollNo());
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentGrade(student.getStudentGrade());
        existingStudent.setStudentSection(student.getStudentSection());
        return repository.save(existingStudent);
    }

}

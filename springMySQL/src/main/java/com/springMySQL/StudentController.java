package com.springMySQL;

import com.springMySQL.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springMySQL.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return service.saveStudents(students);
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        System.out.println("test students");
        return service.getStudents();
    }

    @GetMapping("/studentById/{id}")
    public Student findStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @GetMapping("/studentByName/{studentName}")
    public List<Student> findStudentByName(@PathVariable String studentName) {
        return service.getStudentByName(studentName);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudentById(@PathVariable int id) {
        return service.deleteStudentById(id);
    }

}

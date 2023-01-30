package com.springMySQL;

import com.springMySQL.entity.Student;
import com.springMySQL.entity.StudentMarks;
import com.springMySQL.service.StudentMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springMySQL.service.StudentService;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private StudentMarksService serviceMarks;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        // Sava student detail
        Student tempStudent = service.saveStudent(student);
        // set student id to student marks
        tempStudent.getStudentMarks().forEach(studentMarks -> studentMarks.setStudentId(tempStudent.getStudentId()));
        // calculate total marks for each student marks
        tempStudent.getStudentMarks().forEach(studentMarks -> studentMarks.setTotalMarks(studentMarks.getStuTotalMarks(studentMarks)));
        // save all student marks
        tempStudent.setStudentMarks(serviceMarks.saveStudentMarks(tempStudent.getStudentMarks()));
        return new ResponseEntity<>(tempStudent, HttpStatus.CREATED);
    }

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        // save all students
        List<Student> tempStudents = service.saveStudents(students);
        // get each student from students
        for (Student stu : tempStudents) {
            // update student id to each student marks
            stu.getStudentMarks().forEach(studentMarks -> studentMarks.setStudentId(stu.getStudentId()));
            // update total marks for each student marks
            stu.getStudentMarks().forEach(studentMarks -> studentMarks.setTotalMarks(studentMarks.getStuTotalMarks(studentMarks)));
            // save all student marks
            stu.setStudentMarks(serviceMarks.saveStudentMarks(stu.getStudentMarks()));
        }
        return tempStudents;
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        // get all students details
        return service.getStudents();
    }

    @GetMapping("/studentById/{id}")
    public Student findStudentById(@PathVariable int id) {
        // get student by student id
        return service.getStudentById(id);
    }

    @GetMapping("/studentByName/{studentName}")
    public List<Student> findStudentByName(@PathVariable String studentName) {
        // get student by student name
        return service.getStudentByName(studentName);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {

        // get all student marks
        for (StudentMarks stuMarks : student.getStudentMarks()) {
            // update each student marks
            serviceMarks.updateStudentMarks(stuMarks);
        }
        // update student details
        return service.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudentById(@PathVariable int id) {
        // delete student marks by student id
        serviceMarks.deleteStudentMarksByStudentId(id);
        // delete student
        return service.deleteStudentById(id);
    }

}

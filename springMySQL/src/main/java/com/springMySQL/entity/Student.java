package com.springMySQL.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
// table name in DB
@Table(name = "STUDENT_TBL")
public class Student {
    // primary key
    @Id
    // auto generate id value by 1 - GenerationType.IDENTITY - current table id increment only
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // column name in table
    @Column(name = "student_Id")
    private int studentId;
    // column name in table
    @Column(name = "student_RollNo")
    private String studentRollNo;
    // column name in table
    @Column(name = "student_Name")
    private String studentName;
    // column name in table
    @Column(name = "student_Grade")
    private String studentGrade;
    // column name in table
    @Column(name = "student_Section")
    private String studentSection;
    // student mark table relation
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // foreign key in student mark table
    @JoinColumn(name = "student_Id")
    private List<StudentMarks> studentMarks;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "StudentMarks")
//    private Set<StudentMarks> studentMarks = new Set<StudentMarks>();

//    private String studentJoiningDate;
//    private String studentCurrentStatus;
//    private String studentAddress;
//    private String studentParentMobileNo1;
//    private String studentParentMobileNo2;
//    private String studentFatherName;
//    private String studentMotherName;

}



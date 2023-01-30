package com.springMySQL.entity;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
// table name in DB
@Table(name = "StudentMarks_TBL")
public class StudentMarks {
    // primary key
    @Id
    // auto generate id value by 1 - GenerationType.IDENTITY - current table id increment only
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // column name in table
    @Column(name = "student_MarkId")
    private int studentMarkId;
    // column name in table
    @Column(name = "student_Id")
    private int studentId;
    // column name in table
    @Column(name = "student_Mark1")
    private double studentMark1;
    // column name in table
    @Column(name = "student_Mark2")
    private double studentMark2;
    // column name in table
    @Column(name = "student_Mark3")
    private double studentMark3;
    // column name in table
    @Column(name = "student_Mark4")
    private double studentMark4;
    // column name in table
    @Column(name = "student_Mark5")
    private double studentMark5;
    // column name in table
    @Column(name = "student_TotalMarks")
    private double totalMarks;

    // Student table relation
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    // calculate total marks
    public double getStuTotalMarks(StudentMarks studentMarks) {
        return studentMarks.studentMark1 + studentMarks.studentMark2 + studentMarks.studentMark3 + studentMarks.studentMark4 + studentMarks.studentMark5;
    }

}

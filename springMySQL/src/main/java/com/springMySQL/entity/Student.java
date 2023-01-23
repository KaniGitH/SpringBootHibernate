package com.springMySQL.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "STUDENT_TBL")
public class Student {
    @Id
    @GeneratedValue
    private int studentId;

    private String studentRollNo;
    private String studentName;
    private String studentGrade;
    private String studentSection;
//    private String studentJoiningDate;
//    private String studentCurrentStatus;
//    private String studentAddress;
//    private String studentParentMobileNo1;
//    private String studentParentMobileNo2;
//    private String studentFatherName;
//    private String studentMotherName;

}

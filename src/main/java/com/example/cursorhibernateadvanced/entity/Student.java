package com.example.cursorhibernateadvanced.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {
    @ManyToOne
    @JoinColumn(name = "student_group_id")
    @JsonBackReference
    StudentGroup studentGroup;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "studentGroup=" + studentGroup.getId() +
                '}';
    }
}

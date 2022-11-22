package com.example.cursorhibernateadvanced.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class StudentGroup {
    @OneToMany(mappedBy = "studentGroup", cascade = CascadeType.ALL)
    @JsonManagedReference
    private final List<Student> students = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    public void addStudent(Student student) {
        students.add(student);
        student.setStudentGroup(this);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
        student.setStudentGroup(null);
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "students=" + students +
                ", id=" + id +
                ", teacher=" + teacher +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;

    }
}

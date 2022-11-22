package com.example.cursorhibernateadvanced.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Teacher {

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonManagedReference
    private final List<StudentGroup> groupList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String firstName;
    private String lastName;

    public Teacher addGroup(StudentGroup group) {
        groupList.add(group);
        group.setTeacher(this);
        return this;
    }

    public void deleteTeacherGroup(StudentGroup group) {
        groupList.remove(group);
        group.setTeacher(null);
    }

    public List<StudentGroup> getGroupList() {
        return groupList;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}

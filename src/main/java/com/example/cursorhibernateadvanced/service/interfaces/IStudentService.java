package com.example.cursorhibernateadvanced.service.interfaces;

import com.example.cursorhibernateadvanced.entity.Student;

public interface IStudentService {
    Student createStudent(Student student);

    Student setGroup(Long studentId, Long groupId);

    void deleteStudent(Long id);

    Student deleteGroup(Long studentId);
}

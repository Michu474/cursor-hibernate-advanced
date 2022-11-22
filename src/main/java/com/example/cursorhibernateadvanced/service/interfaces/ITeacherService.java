package com.example.cursorhibernateadvanced.service.interfaces;

import com.example.cursorhibernateadvanced.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher createTeacher(Teacher teacher);

    List<Teacher> getAll();

    Teacher addTeacherGroup(Long teacherId, Long groupId);

    Teacher getTeacher(Long id);

    void deleteTeacherGroup(Long teacherId, Long groupId);
}

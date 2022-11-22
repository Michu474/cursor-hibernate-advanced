package com.example.cursorhibernateadvanced.repository;

import com.example.cursorhibernateadvanced.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Teacher findTeacherById(Long id);


}

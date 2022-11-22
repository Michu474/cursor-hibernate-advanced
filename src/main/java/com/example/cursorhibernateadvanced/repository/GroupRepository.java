package com.example.cursorhibernateadvanced.repository;


import com.example.cursorhibernateadvanced.entity.StudentGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<StudentGroup, Long> {
    StudentGroup findStudentGroupById(Long id);

    List<StudentGroup> findAll();

    List<StudentGroup> findAllStudentGroupsByTeacherId(Long id);

    int countGroupsByTeacherId(Long teacherId);
}

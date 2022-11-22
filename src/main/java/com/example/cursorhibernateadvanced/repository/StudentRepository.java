package com.example.cursorhibernateadvanced.repository;

import com.example.cursorhibernateadvanced.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findStudentById(Long id);

    List<Student> findAllStudentsByStudentGroupId(Long id);
}

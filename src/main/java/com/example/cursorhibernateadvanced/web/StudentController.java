package com.example.cursorhibernateadvanced.web;

import com.example.cursorhibernateadvanced.entity.Student;
import com.example.cursorhibernateadvanced.service.implement.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping(value = "/addStudent")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PostMapping(value = "/setStudentGroup")
    public Student setStudentGroup(@RequestParam Long studentId, @RequestParam Long groupId) {
        return studentService.setGroup(studentId, groupId);
    }

    @DeleteMapping(value = "/deleteStudentGroup")
    public Student deleteStudentGroup(@RequestParam Long studentId) {
        return studentService.deleteGroup(studentId);
    }

    @DeleteMapping(value = "/deleteStudent")
    public void deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(value = "/getStudentsByTeacherId/{teacher_id}")
    public List<Student> getStudentsByTeacherId(@PathVariable Long teacher_id) {
        return studentService.getAllUsersByTeacherId(teacher_id);
    }
}


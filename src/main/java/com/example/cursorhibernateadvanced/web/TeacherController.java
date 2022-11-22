package com.example.cursorhibernateadvanced.web;

import com.example.cursorhibernateadvanced.entity.StudentGroup;
import com.example.cursorhibernateadvanced.entity.Teacher;
import com.example.cursorhibernateadvanced.service.implement.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @PostMapping(value = "/createOrUpdateTeacher")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @GetMapping(value = "/getAll")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAll();
    }

    @GetMapping(value = "/getAllGroups")
    public List<StudentGroup> getAllGroups(@RequestParam Long id) {
        return teacherService.getTeacher(id).getGroupList();
    }

    @PostMapping(value = "/addGroup")
    public Teacher addGroupToTeacher(@RequestParam Long teacherId, @RequestParam Long groupId) {
        return teacherService.addTeacherGroup(teacherId, groupId);
    }

    @DeleteMapping(value = "/deleteTeacherGroup")
    public void deleteGroupFromTeacher(@RequestParam Long teacherId, @RequestParam Long groupId) {
        teacherService.deleteTeacherGroup(teacherId, groupId);
    }
}

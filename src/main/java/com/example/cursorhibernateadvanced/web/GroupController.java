package com.example.cursorhibernateadvanced.web;

import com.example.cursorhibernateadvanced.entity.StudentGroup;
import com.example.cursorhibernateadvanced.entity.Teacher;
import com.example.cursorhibernateadvanced.service.implement.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {

    @Autowired
    private GroupServiceImpl groupService;

    @PostMapping(value = "/createGroup")
    public StudentGroup createGroup() {
        return groupService.createGroup();
    }

    @GetMapping(value = "/getGroupById")
    public StudentGroup getGroupById(@RequestParam Long groupId) {
        return groupService.getGroupById(groupId);
    }

    @GetMapping(value = "/getTeacher")
    public Teacher getTeacher(@RequestParam Long id) {
        System.out.println(groupService.getGroupById(id).getTeacher());
        return groupService.getGroupById(id).getTeacher();
    }

    @GetMapping(value = "/getTeachersGroups/{id}")
    public int getTeachersGroups(@PathVariable Long id) {
        return groupService.getTeacherGroupsCount(id);
    }

}

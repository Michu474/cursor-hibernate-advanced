package com.example.cursorhibernateadvanced.service.interfaces;

import com.example.cursorhibernateadvanced.entity.StudentGroup;

public interface IGroupService {
    StudentGroup createGroup();

    StudentGroup getGroupById(Long id);

    int getTeacherGroupsCount(Long id);
}

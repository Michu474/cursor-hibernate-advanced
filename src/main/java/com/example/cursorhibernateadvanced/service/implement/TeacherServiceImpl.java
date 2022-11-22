package com.example.cursorhibernateadvanced.service.implement;

import com.example.cursorhibernateadvanced.entity.StudentGroup;
import com.example.cursorhibernateadvanced.entity.Teacher;
import com.example.cursorhibernateadvanced.repository.GroupRepository;
import com.example.cursorhibernateadvanced.repository.TeacherRepository;
import com.example.cursorhibernateadvanced.service.interfaces.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacherGroup(Long teacherId, Long groupId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        StudentGroup group = groupRepository.findStudentGroupById(groupId);
        teacher.addGroup(group);
        groupRepository.save(group);
        teacherRepository.save(teacher);
        return teacher;
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findTeacherById(id);
    }

    @Override
    public void deleteTeacherGroup(Long teacherId, Long groupId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        StudentGroup group = groupRepository.findStudentGroupById(groupId);
        teacher.deleteTeacherGroup(group);
        groupRepository.save(group);
        teacherRepository.save(teacher);
    }

}

package com.example.cursorhibernateadvanced.service.implement;

import com.example.cursorhibernateadvanced.entity.Student;
import com.example.cursorhibernateadvanced.entity.StudentGroup;
import com.example.cursorhibernateadvanced.repository.GroupRepository;
import com.example.cursorhibernateadvanced.repository.StudentRepository;
import com.example.cursorhibernateadvanced.service.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student setGroup(Long studentId, Long groupId) {
        Student student = studentRepository.findStudentById(studentId);
        StudentGroup group = groupRepository.findStudentGroupById(groupId);
        group.addStudent(student);
        studentRepository.save(student);
        groupRepository.save(group);
        System.out.println(student);
        return student;
    }

    public Student deleteGroup(Long studentId) {
        Student student = studentRepository.findStudentById(studentId);
        StudentGroup group = student.getStudentGroup();
        group.deleteStudent(student);
        studentRepository.save(student);
        groupRepository.save(group);
        return student;
    }

    public List<Student> getAllUsersByTeacherId(Long teacher_id) {
        List<StudentGroup> groups = groupRepository.findAllStudentGroupsByTeacherId(teacher_id);
        List<Student> students = new ArrayList<>();
        if (groups != null) {
            for (StudentGroup group : groups) {
                students.addAll(studentRepository.findAllStudentsByStudentGroupId(group.getId()));
            }
            return students;
        }
        return null;
    }

}

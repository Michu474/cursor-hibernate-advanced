package com.example.cursorhibernateadvanced.service.implement;

import com.example.cursorhibernateadvanced.entity.StudentGroup;
import com.example.cursorhibernateadvanced.repository.GroupRepository;
import com.example.cursorhibernateadvanced.service.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private GroupRepository groupRepository;

    public StudentGroup createGroup() {
        return groupRepository.save(new StudentGroup());
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public StudentGroup getGroupById(Long id) {
        return groupRepository.findStudentGroupById(id);
    }

    @Override
    public int getTeacherGroupsCount(Long id) {
        return groupRepository.countGroupsByTeacherId(id);
    }


}

package com.example.practice.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    @Autowired
    teacherDAO teacherdao;

    public ArrayList<TeacherWithClassDTO> findAll(){
        ArrayList<TeacherWithClassDTO> members = new ArrayList<>();
        teacherdao.findWithClass().forEach(e->members.add(e));
        return members;
    }
    public void insertTeacher(teacherDTO teacher){
        teacherdao.save(teacher);
    }
}
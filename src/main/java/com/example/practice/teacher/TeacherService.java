package com.example.practice.teacher;

import com.querydsl.core.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    teacherDAO teacherdao;

    public ArrayList<TeacherWithClass> findAll(){
        ArrayList<TeacherWithClass> members = new ArrayList<>();
        teacherdao.findWithClass().forEach(e->members.add(e));
        return members;
    }
    public void insertTeacher(teacherDTO teacher){
        teacherdao.save(teacher);
    }
}
package com.example.practice.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    @Autowired
    teacherDAO teacherdao;

    public ArrayList<teacherDTO> findAll(){
        ArrayList<teacherDTO> members = new ArrayList<>();
        teacherdao.findAll().forEach(e->members.add(e));
        //System.out.println(teacherdao.findByName("최우혁").get().getBirthday());
        return members;
    }
    public void insertTeacher(teacherDTO teacher){
        teacherdao.save(teacher);
    }
}
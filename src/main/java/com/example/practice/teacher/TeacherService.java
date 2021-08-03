package com.example.practice.teacher;

import com.example.practice.classinf.ClassEntity;
import com.example.practice.classinf.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    @Autowired
    teacherDAO teacherdao;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ClassService classService;

    public ArrayList<TeacherWithClassDTO> findAll(){
        ArrayList<TeacherWithClassDTO> members = new ArrayList<>();
        teacherdao.findWithClass().forEach(e->members.add(e));
        return members;
    }
    public void insertTeacher(TeacherDTO teacher,String className){
        TeacherEntity teacherEntity=new TeacherEntity();
        modelMapper.map(teacher,teacherEntity);
        ClassEntity classEntity = classService.findbyName(className);
        teacherEntity.setClassEntity(classEntity);
        try {
            teacherdao.save(teacherEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
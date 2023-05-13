package com.example.practice.teacher;

import com.example.practice.classinf.ClassEntity;
import com.example.practice.classinf.ClassService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherdao;
    private final ModelMapper modelMapper;
    private final ClassService classService;

    public ArrayList<TeacherWithClassDTO> findAll() {
        ArrayList<TeacherWithClassDTO> members = new ArrayList<>();
        teacherdao.findWithClass().forEach(e->members.add(e));
        return members;
    }

    @Transactional
    public void createTeacher(TeacherCreateRequestDTO teacherCreateRequestDTO){
        TeacherEntity teacherEntity=new TeacherEntity();
        modelMapper.map(teacherCreateRequestDTO,teacherEntity);
        ClassEntity classEntity = classService.findbyName(teacherCreateRequestDTO.getClassName());
        teacherEntity.setClassEntity(classEntity);
        teacherdao.save(teacherEntity);
    }
}
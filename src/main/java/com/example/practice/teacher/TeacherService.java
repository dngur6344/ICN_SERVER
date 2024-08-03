package com.example.practice.teacher;

import com.example.practice.classInfo.ClassInfo;
import com.example.practice.classInfo.ClassInfoService;
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
    private final ClassInfoService classInfoService;

    public ArrayList<TeacherWithClassDTO> findAll() {
        ArrayList<TeacherWithClassDTO> members = new ArrayList<>();
        teacherdao.findWithClass().forEach(e->members.add(e));
        return members;
    }

    @Transactional
    public void createTeacher(TeacherCreateRequestDTO teacherCreateRequestDTO){
        Teacher teacher =new Teacher();
        modelMapper.map(teacherCreateRequestDTO, teacher);
        ClassInfo aClassInfo = classInfoService.findbyName(teacherCreateRequestDTO.getClassName());
        teacher.setClassInfo(aClassInfo);
        teacherdao.save(teacher);
    }
}
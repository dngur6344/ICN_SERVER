package com.example.practice.classInfo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassInfoService {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    ModelMapper modelMapper;
    public void insertingClass(ClassDTO classDTO){
        ClassInfo aClassInfo = new ClassInfo();
        modelMapper.map(classDTO, aClassInfo);
        classRepository.save(aClassInfo);
    }
    public ClassInfo findbyName(String name){
        return classRepository.findByClassname(name);
    }
}

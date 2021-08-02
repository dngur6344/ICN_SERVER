package com.example.practice.classinf;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    ModelMapper modelMapper;
    public void insertingClass(ClassDTO classDTO){
        ClassEntity classEntity = new ClassEntity();
        modelMapper.map(classDTO,classEntity);
        classRepository.save(classEntity);
    }
    public ClassEntity findbyName(String name){
        return classRepository.findByClassname(name);
    }
}

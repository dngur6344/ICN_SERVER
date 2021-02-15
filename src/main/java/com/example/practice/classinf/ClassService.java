package com.example.practice.classinf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {
    @Autowired
    ClassRepository classRepository;
    public void insertingClass(ClassEntity classEntity){
        classRepository.save(classEntity);
    }
}

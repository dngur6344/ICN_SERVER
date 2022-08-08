package com.example.practice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ArrayList<StudentWithClassDTO> findWithClassAll(){
        return studentRepository.findWithClassAll();
    }

    @Transactional
    public void Save(StudentEntity studentEntity){
        studentRepository.save(studentEntity);
    }

    public ArrayList<StudentWithClassDTO> findByClassName(String className){
        return studentRepository.findByClassName(className);
    }
}

package com.example.practice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ArrayList<StudentWithClassDTO> findWithClassAll(){
        return studentRepository.findWithClassAll();
    }
    public void Save(StudentEntity studentEntity){
        studentRepository.save(studentEntity);
    }
}

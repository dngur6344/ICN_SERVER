package com.example.practice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="/all")
    public ArrayList<StudentWithClassDTO> findWithClass(){
        return studentService.findWithClassAll();
    }
}

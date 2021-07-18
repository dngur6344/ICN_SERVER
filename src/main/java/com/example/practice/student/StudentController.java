package com.example.practice.student;

import com.example.practice.classinf.ClassEntity;
import com.example.practice.classinf.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ClassService classService;

    @RequestMapping(value="/all")
    public ArrayList<StudentWithClassDTO> findWithClass(){
        return studentService.findWithClassAll();
    }
    @GetMapping(value="/insert")
    public String insertStudent(@RequestParam(value="name") String name, @RequestParam(value="birthday") String birthday,@RequestParam("classname") String classname){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(name);
        studentEntity.setBirthday(birthday);
        ClassEntity classEntity = classService.findbyName(classname);
        studentEntity.setClassEntity(classEntity);
        studentService.Save(studentEntity);
        return "good";
    }
}

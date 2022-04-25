package com.example.practice.student;

import com.example.practice.classinf.ClassEntity;
import com.example.practice.classinf.ClassService;
import com.example.practice.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping(value="/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ClassService classService;

    @RequestMapping(value="/all")
    public ResponseEntity<ResponseMessage> findWithClass(){
        ArrayList<StudentWithClassDTO> studentList = studentService.findWithClassAll();

        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(studentList)
                .build();

        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @GetMapping(value="/insert")
    public void insertStudent(@RequestParam(value="name") String name, @RequestParam(value="birthday") String birthday,@RequestParam("classname") String classname){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(name);
        studentEntity.setBirthday(birthday);
        ClassEntity classEntity = classService.findbyName(classname);
        studentEntity.setClassEntity(classEntity);
        studentService.Save(studentEntity);
    }

    @RequestMapping(value="/search/{class}")
    public ResponseEntity<ResponseMessage> findByClassName(@PathVariable(value = "class")String className){
        ArrayList<StudentWithClassDTO> studentList = studentService.findByClassName(className);

        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(studentList)
                .build();

        return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);

    }
}

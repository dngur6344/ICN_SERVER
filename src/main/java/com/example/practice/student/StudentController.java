package com.example.practice.student;

import com.example.practice.classinf.ClassService;
import com.example.practice.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping(value="/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    private final ClassService classService;

    @RequestMapping(value="/all")
    public ResponseEntity<ResponseMessage> findWithClass(){
        ArrayList<StudentWithClassDTO> studentList = studentService.findWithClassAll();

        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(studentList)
                .build();

        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping
    public void insertStudent(StudentCreateRequestDTO request){
        studentService.createStudent(request);
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

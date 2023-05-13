package com.example.practice.teacher;

import com.example.practice.classinf.ClassService;
import com.example.practice.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final ClassService classService;
    private final TeacherService teacherService;

    @GetMapping(value="/all")
    public ResponseEntity<ResponseMessage>  findAll(){
        List<TeacherWithClassDTO> list = teacherService.findAll();

        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(list)
                .build();

        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping
    public void createteacher(@RequestBody TeacherCreateRequestDTO requestDTO){
        teacherService.createTeacher(requestDTO);
    }
}

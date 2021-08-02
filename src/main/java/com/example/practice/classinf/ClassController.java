package com.example.practice.classinf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/class")
public class ClassController {

    @Autowired
    ClassService classService;

    @PostMapping(value="/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void inserting(@RequestBody ClassDTO classDTO){
        classService.insertingClass(classDTO);
    }
}

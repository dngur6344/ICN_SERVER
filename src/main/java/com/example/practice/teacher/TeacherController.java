package com.example.practice.teacher;

//import com.example.practice.calendar.calendarDTO;
import com.example.practice.classinf.ClassEntity;
import com.example.practice.classinf.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/teacher")
public class TeacherController {
    @Autowired
    ClassService classService;
    @Autowired
    TeacherService teacherService;
    @GetMapping(value="/all")
    public List<TeacherWithClassDTO> findAll(){
        return teacherService.findAll();
    }

    @RequestMapping(value="/insert")
    public void inserting(@RequestParam(name="name") String teacherName, @RequestParam(name="birthday") String birthday, @RequestParam(name="classname")String classname){
        TeacherDTO teacher = new TeacherDTO();
        teacher.setTeacherName(teacherName);
        teacher.setBirthday(birthday);
        teacherService.insertTeacher(teacher,classname);
    }
}

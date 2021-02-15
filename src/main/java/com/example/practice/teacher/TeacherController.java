package com.example.practice.teacher;

//import com.example.practice.calendar.calendarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/teacher")
public class TeacherController {
    @Autowired
    TeacherService tt;
    @GetMapping(value="/all")
    public List<TeacherWithClass> findAll(){
        return tt.findAll();
    }

    @RequestMapping(value="/insert")
    public void inserting(@RequestParam(name="name") String teacherName, @RequestParam(name="birthday") String birthday){
        teacherDTO teacher = new teacherDTO();
        teacher.setTeacherName(teacherName);
        teacher.setBirthday(birthday);
        tt.insertTeacher(teacher);
    }
}

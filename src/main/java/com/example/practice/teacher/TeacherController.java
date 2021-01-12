package com.example.practice.teacher;

//import com.example.practice.calendar.calendarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/example")
public class TeacherController {
    @Autowired
    TeacherService tt;
    @GetMapping(value="/all")
    public List<teacherDTO> findAll(){
        return tt.findAll();
    }

    @RequestMapping(value="/insert")
    public void inserting(@RequestParam(name="name") String name, @RequestParam(name="birthday") String birthday){
        teacherDTO teacher = new teacherDTO();
        teacher.setName(name);
        teacher.setBirthday(birthday);
        tt.insertTeacher(teacher);
    }
}

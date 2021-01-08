package com.example.practice.teacher;

//import com.example.practice.calendar.calendarDTO;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeWithZoneIdSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/example")
public class TeacherController {
    @Autowired
    teacherDAOImpl tt;
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

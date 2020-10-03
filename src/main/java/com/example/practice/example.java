package com.example.practice;

import com.example.practice.calendar.calendarDTO;
import com.example.practice.teacher.teacherDAOImpl;
import com.example.practice.teacher.teacherDTO;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeWithZoneIdSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/example")
public class example {
    @Autowired
    teacherDAOImpl tt;

    @RequestMapping(value="/all")
    public List<teacherDTO> method3(){
        return tt.getTeachers();
    }

    @RequestMapping(value="/{idx}")
    public teacherDTO method1(@PathVariable("idx") int idx) {
        System.out.println(tt.getTeachers().get(idx).getName());
        return tt.getTeachers().get(idx);
    }
    @RequestMapping(value="/method2",method= RequestMethod.GET)
    public void method2(@RequestParam(name="name") String name,@RequestParam(name="birthday") String birthday) {
        teacherDTO teacher = new teacherDTO();
        teacher.setName(name);
        teacher.setBirthday(birthday);
        tt.insertTeacher(teacher);
    }
}

package com.example.practice.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class calendarController {
    @Autowired
    calendarDAOImpl calendar;

    @RequestMapping(value="/all")
    public List<calendarDTO> getAll(){
        return calendar.getAllSchedules();
    }
    @RequestMapping(value="/insertEvent",method= RequestMethod.GET)
    public void insertEvent(@RequestParam(name="moment") String moment, @RequestParam(name="title") String title, @RequestParam(name="description") String description){
        calendarDTO calendarDTO = new calendarDTO();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = transFormat.parse(moment);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendarDTO.setMoment(date);
        calendarDTO.setTitle(title);
        calendarDTO.setDescription(description);
        calendar.insertSchedule(calendarDTO);
    }
}

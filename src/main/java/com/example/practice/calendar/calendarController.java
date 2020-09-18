package com.example.practice.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

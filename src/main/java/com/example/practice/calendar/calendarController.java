package com.example.practice.calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static java.util.Calendar.HOUR;

@RestController
@RequestMapping(value = "/schedule")
public class calendarController {
    @Autowired
    calendarDAOImpl calendar;

    @RequestMapping(value="/all")
    public List<calendarDTO> getAll(){
        Calendar cal = Calendar.getInstance();
        List<calendarDTO> listing = calendar.getAllSchedules();
        for(int i=0;i<listing.size();i++){//현재 시간대 맞추기(한국 시간대=UTC+9)
            cal.setTime(listing.get(i).getMoment());
            cal.add(HOUR, 9);
            listing.get(i).setMoment(cal.getTime());
        }
        return listing;
    }
    /*@RequestMapping(value="/insertEvent",method= RequestMethod.GET)
    public void insertEvent(@RequestParam(name="moment") String moment, @RequestParam(name="title") String title, @RequestParam(name="description") String description){
        calendarDTO calendarDTO = new calendarDTO();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        //transFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
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
    }*/
    @PostMapping(value="/insertEvent",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEvent(@RequestBody calendarDTO calendarDTO){
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        calendar.insertSchedule(calendarDTO);
    }
}

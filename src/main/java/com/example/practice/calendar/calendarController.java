package com.example.practice.calendar;

import com.example.practice.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.HOUR;

@RestController
@RequestMapping(value = "/schedule")
public class calendarController {
    @Autowired
    CalendarService calendar;

    @RequestMapping(value="/all")
    public ResponseEntity<ResponseMessage> getAll(){
        Calendar cal = Calendar.getInstance();
        List<CalendarDTO> listing = calendar.getAllSchedules();
        for(int i=0;i<listing.size();i++){//현재 시간대 맞추기(한국 시간대=UTC+9)
            cal.setTime(listing.get(i).getMoment());
            cal.add(HOUR, 9);
            listing.get(i).setMoment(cal.getTime());
        }
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(listing)
                .build();
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }
    @RequestMapping(value="/last")
    public ResponseEntity<ResponseMessage> getLastEvent(){
        List<CalendarDTO> calendarList = calendar.getLastEvent();
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(calendarList)
                .build();
        return new ResponseEntity<ResponseMessage>(responseMessage,HttpStatus.OK);
    }
    @PostMapping(value="/insertEvent",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEvent(@RequestBody CalendarDTO calendarDTO){
        calendar.insertSchedule(calendarDTO);
    }
    @PostMapping(value="/deleteEvent")
    public void deleteEvent(@RequestBody CalendarDTO calendarDTO){
        calendar.deleteSchedule(calendarDTO);
    }
}

package com.example.practice.calendar;

import com.example.practice.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendar;

    @RequestMapping(value = "/all")
    public ResponseEntity<ResponseMessage> getAll() {
        List<CalendarDTO> listing = calendar.getAllSchedules();
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(listing)
                .build();
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @RequestMapping(value = "/last")
    public ResponseEntity<ResponseMessage> getLastEvent() {
        List<CalendarDTO> calendarList = calendar.getLastEvent();
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(calendarList)
                .build();
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping(value = "/insertEvent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEvent(@RequestBody CalendarDTO calendarDTO) {
        calendar.insertSchedule(calendarDTO);
    }

    @PostMapping(value = "/deleteEvent")
    public void deleteEvent(@RequestBody CalendarDTO calendarDTO) {
        calendar.deleteSchedule(calendarDTO);
    }
}

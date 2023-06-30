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
    private final CalendarService calendarService;

    @RequestMapping(value = "/all")
    public ResponseEntity<ResponseMessage> getAll() {
        List<CalendarDTO> calendarList = calendarService.getAllSchedules();
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(calendarList)
                .build();
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @RequestMapping(value = "/last")
    public ResponseEntity<ResponseMessage> getLastEvent() {
        List<CalendarDTO> calendarList = calendarService.getLastEvent();
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(calendarList)
                .build();
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping(value = "/insertEvent", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEvent(@RequestBody CalendarDTO calendarDTO) {
        calendarService.insertSchedule(calendarDTO);
    }

    @PostMapping(value = "/deleteEvent")
    public void deleteEvent(@RequestBody CalendarDTO calendarDTO) {
        calendarService.deleteSchedule(calendarDTO);
    }
}

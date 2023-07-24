package com.example.practice.calendar;

import com.example.practice.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping
    public ResponseEntity<ResponseMessage> getEvents() {
        List<CalendarDto> calendarList = calendarService.getAllSchedules();

        return createResponseEntity(calendarList);
    }

    @RequestMapping(value = "/last")
    public ResponseEntity<ResponseMessage> getLastEvent() {
        List<CalendarDto> calendarList = calendarService.getLastEvent();

        return createResponseEntity(calendarList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> createEvent(@RequestBody CalendarDto calendarDTO) {
        calendarService.createSchedule(calendarDTO);

        return createResponseEntity(null);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseMessage> deleteEvent(@PathVariable("id") Long id) {
        calendarService.deleteSchedule(id.intValue());

        return createResponseEntity(null);
    }

    private ResponseEntity<ResponseMessage> createResponseEntity(Object data) {
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(data)
                .build();
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }
}

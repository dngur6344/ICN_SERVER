package com.example.practice.calendar;

import java.util.List;

public interface CalendarService {
    List<CalendarDTO> getAllSchedules();
    void insertSchedule(CalendarDTO calendardto);
    void deleteSchedule(CalendarDTO calendardto);
    List<CalendarDTO> getLastEvent();
}

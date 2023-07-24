package com.example.practice.calendar;

import java.util.List;

public interface CalendarService {
    List<CalendarDto> getAllSchedules();
    void createSchedule(CalendarDto calendardto);
    void deleteSchedule(Integer scheduleId);
    List<CalendarDto> getLastEvent();
}

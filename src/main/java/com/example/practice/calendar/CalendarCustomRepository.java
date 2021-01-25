package com.example.practice.calendar;

import java.util.List;

public interface CalendarCustomRepository {
    List<calendarDTO> findRecentEvent(int limit);
}

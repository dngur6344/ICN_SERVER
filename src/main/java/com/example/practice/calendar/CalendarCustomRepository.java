package com.example.practice.calendar;

import java.util.List;

public interface CalendarCustomRepository {
    List<Calendar> findRecentEvent(int limit);
}

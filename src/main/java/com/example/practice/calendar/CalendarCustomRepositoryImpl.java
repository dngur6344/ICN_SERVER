package com.example.practice.calendar;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CalendarCustomRepositoryImpl extends QuerydslRepositorySupport implements CalendarCustomRepository {
    public CalendarCustomRepositoryImpl(){
        super(Calendar.class);
    }

    @Override
    public List<Calendar> findRecentEvent(int limit) {
        final com.example.practice.calendar.QCalendarEntity calendar = QCalendarEntity.calendarEntity;
        return from(calendar).orderBy(calendar.moment.desc()).limit(1).fetch();
    }
}

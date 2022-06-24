package com.example.practice.calendar;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CalendarCustomRepositoryImpl extends QuerydslRepositorySupport implements CalendarCustomRepository {
    public CalendarCustomRepositoryImpl(){
        super(CalendarEntity.class);
    }

    @Override
    public List<CalendarEntity> findRecentEvent(int limit) {
        final com.example.practice.calendar.QCalendarEntity calendar = QCalendarEntity.calendarEntity;
        return from(calendar).orderBy(calendar.moment.desc()).limit(1).fetch();
    }
}

package com.example.practice.calendar;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CalendarCustomRepositoryImpl extends QuerydslRepositorySupport implements CalendarCustomRepository {
    public CalendarCustomRepositoryImpl(){
        super(calendarDTO.class);
    }

    @Override
    public List<calendarDTO> findRecentEvent(int limit) {
        final com.example.practice.calendar.QcalendarDTO calendardto = com.example.practice.calendar.QcalendarDTO.calendarDTO;
        return from(calendardto).orderBy(calendardto.moment.desc()).limit(1).fetch();
    }
}

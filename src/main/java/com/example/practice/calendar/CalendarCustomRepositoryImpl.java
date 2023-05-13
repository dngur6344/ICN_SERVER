package com.example.practice.calendar;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import com.example.practice.calendar.QCalendar;
import java.util.List;

public class CalendarCustomRepositoryImpl extends QuerydslRepositorySupport implements CalendarCustomRepository {
    public CalendarCustomRepositoryImpl(){
        super(Calendar.class);
    }

    @Override
    public List<Calendar> findRecentEvent(int limit) {
        QCalendar calendar = QCalendar.calendar;
        return from(calendar).orderBy(calendar.moment.desc()).limit(1).fetch();
    }
}

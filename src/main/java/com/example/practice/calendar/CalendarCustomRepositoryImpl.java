package com.example.practice.calendar;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.practice.calendar.QCalendar.calendar;

@RequiredArgsConstructor
public class CalendarCustomRepositoryImpl implements CalendarCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Calendar> findRecentEvent(int limit) {
        return jpaQueryFactory.selectFrom(calendar).orderBy(calendar.moment.desc()).limit(1).fetch();
    }
}

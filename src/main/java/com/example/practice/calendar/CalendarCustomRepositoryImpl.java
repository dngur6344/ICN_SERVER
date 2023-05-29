package com.example.practice.calendar;

import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.example.practice.calendar.QCalendar.calendar;

public class CalendarCustomRepositoryImpl implements CalendarCustomRepository {
    public CalendarCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Calendar> findRecentEvent(int limit) {
        return jpaQueryFactory.selectFrom(calendar).orderBy(calendar.moment.desc()).limit(1).fetch();
    }
}

package com.example.practice.calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class calendarDAOImpl implements calendarDAO{
    protected static final String namespace = "com.example.practice.calendar.calendarDAOImpl.";
    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<calendarDTO> getAllSchedules() {
        return sqlSession.selectList(namespace+"getAllSchedules");
    }
}

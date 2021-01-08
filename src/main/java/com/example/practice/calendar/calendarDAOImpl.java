package com.example.practice.calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class calendarDAOImpl{
    @Autowired
    calendarDAO calendardao;

    public List<calendarDTO> getAllSchedules(){
        return calendardao.findAll();
    }
    public void insertSchedule(calendarDTO calendardto){
        calendardao.save(calendardto);
    }
    public void deleteSchedule(calendarDTO calendardto){
        calendardao.deleteById(calendardto.getSchedule_no());
    }
}
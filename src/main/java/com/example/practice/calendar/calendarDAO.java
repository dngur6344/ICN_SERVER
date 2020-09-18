package com.example.practice.calendar;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface calendarDAO {
    public List<calendarDTO> getAllSchedules();
}

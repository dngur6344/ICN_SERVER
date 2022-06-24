package com.example.practice.calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarService {
    @Autowired
    CalendarRepository calendarRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<CalendarDTO> getAllSchedules(){
        List<CalendarEntity> calendarList = calendarRepository.findAll();
        List<CalendarDTO> calendarDTOList = calendarList.stream().map(p->modelMapper.map(p,CalendarDTO.class)).collect(Collectors.toList());
        return calendarDTOList;
    }
    public void insertSchedule(CalendarDTO calendardto){
        CalendarEntity calendarEntity = new CalendarEntity();
        modelMapper.map(calendardto,calendarEntity);
        try {
            calendarRepository.save(calendarEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteSchedule(CalendarDTO calendardto){
        try {
            calendarRepository.deleteById(calendardto.getSchedule_no());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<CalendarDTO> getLastEvent(){
        List<CalendarEntity> calendarList =  calendarRepository.findRecentEvent(1);
        List<CalendarDTO> calendarDTOList =calendarList.stream().map(p->modelMapper.map(p,CalendarDTO.class)).collect(Collectors.toList());
        return calendarDTOList;
    }
}

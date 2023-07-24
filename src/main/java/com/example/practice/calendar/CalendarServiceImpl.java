package com.example.practice.calendar;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Calendar.HOUR;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;
    private final ModelMapper modelMapper;

    public List<CalendarDto> getAllSchedules() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        List<Calendar> calendarList = calendarRepository.findAll();

        List<CalendarDto> calendarDtoList = calendarList.stream()
                .map(p -> modelMapper.map(p, CalendarDto.class))
                .map(calendarDto -> {
                    cal.setTime(calendarDto.getMoment());
                    cal.add(HOUR, 9);
                    calendarDto.setMoment(cal.getTime());
                    return calendarDto;
                }).collect(Collectors.toList());

        return calendarDtoList;
    }

    @Transactional
    public void createSchedule(CalendarDto calendardto) {
        Calendar calendar = Calendar.builder().build();
        modelMapper.map(calendardto, calendar);
        calendarRepository.save(calendar);
    }

    @Transactional
    public void deleteSchedule(Integer scheduleId) {
        calendarRepository.deleteById(scheduleId);
    }

    public List<CalendarDto> getLastEvent() {
        List<Calendar> calendarList = calendarRepository.findRecentEvent(1);
        List<CalendarDto> calendarDtoList = calendarList.stream().map(p -> modelMapper.map(p, CalendarDto.class)).collect(Collectors.toList());
        return calendarDtoList;
    }
}

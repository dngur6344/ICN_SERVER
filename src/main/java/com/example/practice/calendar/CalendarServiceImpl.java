package com.example.practice.calendar;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;
    private final ModelMapper modelMapper;

    public List<CalendarDto> getAllSchedules() {
        List<Calendar> calendarList = calendarRepository.findAll();

        List<CalendarDto> calendarDtoList = calendarList.stream().map(
                calendar -> CalendarDto.builder()
                        .scheduleId(calendar.getScheduleId())
                        .title(calendar.getTitle())
                        .description(calendar.getDescription())
                        .moment(calendar.getMoment())
                        .build())
                .collect(Collectors.toList());

        return calendarDtoList;
    }

    @Transactional
    public void createSchedule(CalendarDto calendardto) {
        Calendar calendar = Calendar.builder()
                .title(calendardto.getTitle())
                .description(calendardto.getDescription())
                .moment(calendardto.getMoment())
                .build();
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

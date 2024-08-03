package com.example.practice.calendar;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
    private final CalendarRepository calendarRepository;

    @Transactional(readOnly = true)
    public List<CalendarDto> getAllSchedules() {
        List<Calendar> calendarList = calendarRepository.findAll();

        return calendarList
                .stream()
                .map(CalendarDto::fromEntity)
                .collect(Collectors.toList());
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

    @Transactional(readOnly = true)
    public List<CalendarDto> getLastEvent() {
        List<Calendar> calendarList = calendarRepository.findRecentEvent(1);
        return calendarList
                .stream()
                .map(CalendarDto::fromEntity)
                .collect(Collectors.toList());
    }
}

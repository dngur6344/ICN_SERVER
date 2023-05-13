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

    public List<CalendarDTO> getAllSchedules() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        List<Calendar> calendarList = calendarRepository.findAll();

        List<CalendarDTO> calendarDTOList = calendarList.stream()
                .map(p -> modelMapper.map(p, CalendarDTO.class))
                .map(calendarDTO -> {
                    cal.setTime(calendarDTO.getMoment());
                    cal.add(HOUR, 9);
                    calendarDTO.setMoment(cal.getTime());
                    return calendarDTO;
                }).collect(Collectors.toList());

        return calendarDTOList;
    }

    @Transactional
    public void insertSchedule(CalendarDTO calendardto) {
        Calendar calendar = Calendar.builder().build();
        modelMapper.map(calendardto, calendar);
        calendarRepository.save(calendar);
    }

    @Transactional
    public void deleteSchedule(CalendarDTO calendardto) {
        calendarRepository.deleteById(calendardto.getSchedule_no());
    }

    public List<CalendarDTO> getLastEvent() {
        List<Calendar> calendarList = calendarRepository.findRecentEvent(1);
        List<CalendarDTO> calendarDTOList = calendarList.stream().map(p -> modelMapper.map(p, CalendarDTO.class)).collect(Collectors.toList());
        return calendarDTOList;
    }
}

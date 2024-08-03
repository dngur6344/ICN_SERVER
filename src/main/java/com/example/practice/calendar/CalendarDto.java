package com.example.practice.calendar;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CalendarDto {
    private final Integer scheduleId;
    private final LocalDate moment;
    private final String title;
    private final String description;

    @Builder
    public CalendarDto(Integer scheduleId, LocalDate moment, String title, String description) {
        this.scheduleId = scheduleId;
        this.moment = moment;
        this.title = title;
        this.description = description;
    }

    public static CalendarDto fromEntity(Calendar calendar) {
        return CalendarDto.builder()
                .scheduleId(calendar.getScheduleId())
                .moment(calendar.getMoment())
                .title(calendar.getTitle())
                .description(calendar.getDescription())
                .build();
    }
}

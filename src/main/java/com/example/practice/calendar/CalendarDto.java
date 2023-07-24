package com.example.practice.calendar;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CalendarDto {
    private Integer scheduleId;
    private LocalDate moment;
    private String title;
    private String description;

    @Builder
    public CalendarDto(Integer scheduleId, LocalDate moment, String title, String description) {
        this.scheduleId = scheduleId;
        this.moment = moment;
        this.title = title;
        this.description = description;
    }
}

package com.example.practice.calendar;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CalendarDto {
    private Integer scheduleId;
    public Date moment;
    public String title;
    public String description;
}

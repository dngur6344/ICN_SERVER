package com.example.practice.calendar;

import java.util.Date;

public class calendarDTO {
    public Date moment;
    public String title;
    public String description;
    public Date getMoment() {
        return moment;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

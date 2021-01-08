package com.example.practice.calendar;

import javax.persistence.*;
import java.util.Date;

@Entity(name="schedule")
public class calendarDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schedule_no;
    @Column(length=100,nullable = false)
    public Date moment;
    @Column(length=100,nullable = false)
    public String title;
    @Column(length=100,nullable = true)
    public String description;
    public Date getMoment() {
        return moment;
    }

    public Integer getSchedule_no() {
        return schedule_no;
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

package com.example.practice.calendar;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(sequenceName = "SCHEDULESEQUENCE", name = "SCHEDULESEQUENCE",initialValue = 1,allocationSize = 1)
@Entity(name="schedule")
public class CalendarEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULESEQUENCE") //oracle의 경우 이런식으로 기본키 할당을 해줘야함.
    @Column(name = "schedule_no")
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

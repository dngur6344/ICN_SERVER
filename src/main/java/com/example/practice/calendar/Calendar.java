package com.example.practice.calendar;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@SequenceGenerator(sequenceName = "SCHEDULESEQUENCE", name = "SCHEDULESEQUENCE",initialValue = 1,allocationSize = 1)
@Entity(name="schedule")
@Getter
@Setter
@NoArgsConstructor
public class Calendar {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULESEQUENCE") //oracle의 경우 이런식으로 기본키 할당을 해줘야함.
    @Column(name = "schedule_no")
    private Integer scheduleNo;
    @Column(length=100,nullable = false)
    public Date moment;
    @Column(length=100,nullable = false)
    public String title;
    @Column(length=100,nullable = true)
    public String description;

    @Builder
    public Calendar(Date moment, String title, String description) {
        this.moment = moment;
        this.title = title;
        this.description = description;
    }
}

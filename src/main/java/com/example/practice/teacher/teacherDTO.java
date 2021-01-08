package com.example.practice.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)*/
@Entity(name="teacher")
public class teacherDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherNo;

    @Column(length=100,nullable = false)
    private String name;
    @Column(length=100,nullable = false)
    private String birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public teacherDTO() {
    }

    public teacherDTO(Integer teacherNo, String name, String birthday) {
        this.teacherNo = teacherNo;
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }
}
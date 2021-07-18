package com.example.practice.teacher;

import com.example.practice.classinf.ClassEntity;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEACHERSEQUENCE") //oracle의 경우 이런식으로 기본키 할당을 해줘야함.
    @SequenceGenerator(sequenceName = "TEACHERSEQUENCE", name = "TEACHERSEQUENCE", allocationSize = 1)
    private Integer teacherNo;

    @Column(length=100,nullable = false)
    private String teacherName;
    @Column(length=100,nullable = false)
    private String birthday;

    @ManyToOne(fetch=FetchType.LAZY)//Lazy로 해두어서 직접 접근하기 전까진 N+1 상황이 일어나지 않음.
    @JoinColumn(name="class_no",nullable=false,updatable=false)
    private ClassEntity classEntity;

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public teacherDTO() {
    }

    public teacherDTO(Integer teacherNo, String teacherName, String birthday, ClassEntity classEntity) {
        this.teacherNo = teacherNo;
        this.teacherName = teacherName;
        this.birthday = birthday;
        this.classEntity = classEntity;
    }

    public teacherDTO(Integer teacherNo, String teacherName, String birthday) {
        this.teacherNo = teacherNo;
        this.teacherName = teacherName;
        this.birthday = birthday;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getBirthday() {
        return birthday;
    }
}
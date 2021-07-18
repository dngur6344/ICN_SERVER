package com.example.practice.student;

import com.example.practice.classinf.ClassEntity;

import javax.persistence.*;

@Entity(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTSEQUENCE") //oracle의 경우 이런식으로 기본키 할당을 해줘야함.
    @SequenceGenerator(sequenceName = "STUDENTSEQUENCE", name = "STUDENTSEQUENCE", allocationSize = 1)
    private Integer studentNo;

    @Column(length = 100,nullable = false)
    private String studentName;

    @Column(length=100,nullable = false)
    private String birthday;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    @ManyToOne(fetch=FetchType.LAZY)//Lazy로 해두어서 직접 접근하기 전까진 N+1 상황이 일어나지 않음.
    @JoinColumn(name="class_no",nullable=false,updatable=false)
    private ClassEntity classEntity;

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}

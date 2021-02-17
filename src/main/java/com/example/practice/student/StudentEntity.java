package com.example.practice.student;

import com.example.practice.classinf.ClassEntity;

import javax.persistence.*;

@Entity(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentNo;

    @Column(length = 100,nullable = false)
    private String studentName;

    @Column(length=100,nullable = false)
    private String birthday;

    @ManyToOne(fetch=FetchType.LAZY)//Lazy로 해두어서 직접 접근하기 전까진 N+1 상황이 일어나지 않음.
    @JoinColumn(name="class_no",nullable=false,updatable=false)
    private ClassEntity classEntity;

}

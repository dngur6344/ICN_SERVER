package com.example.practice.classinf;

import com.example.practice.student.StudentEntity;
import com.example.practice.teacher.teacherDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="class")
public class ClassEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASSSEQUENCE") //oracle의 경우 이런식으로 기본키 할당을 해줘야함.
    @SequenceGenerator(sequenceName = "CLASSSEQUENCE", name = "CLASSSEQUENCE", allocationSize = 1)
    private Integer classNo;

    @Column(length=100,nullable = false)
    private String classname;

    @OneToMany
    @JoinColumn(name = "class_no")
    List<teacherDTO> teachers = new ArrayList<teacherDTO>();

    @OneToMany
    @JoinColumn(name="class_no")
    List<StudentEntity> students = new ArrayList<>();

    public ClassEntity() {
    }

    public ClassEntity(String classname) {
        this.classname = classname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}
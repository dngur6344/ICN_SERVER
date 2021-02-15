package com.example.practice.classinf;

import com.example.practice.teacher.teacherDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="class")
public class ClassEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classNo;

    @Column(length=100,nullable = false)
    private String classname;

    @OneToMany
    @JoinColumn(name = "class_no")
    List<teacherDTO> teachers = new ArrayList<teacherDTO>();


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
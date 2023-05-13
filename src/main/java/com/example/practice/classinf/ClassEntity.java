package com.example.practice.classinf;

import com.example.practice.student.Student;
import com.example.practice.teacher.TeacherEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    List<TeacherEntity> teachers = new ArrayList<TeacherEntity>();

    @OneToMany
    @JoinColumn(name="class_no")
    List<Student> students = new ArrayList<>();

    public ClassEntity() {
    }

    public ClassEntity(String classname) {
        this.classname = classname;
    }
}
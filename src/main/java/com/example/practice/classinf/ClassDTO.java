package com.example.practice.classinf;

import com.example.practice.student.StudentEntity;
import com.example.practice.teacher.TeacherEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ClassDTO {
    private Integer classNo;
    private String classname;

}

package com.example.practice.teacher;

import com.example.practice.classinf.ClassEntity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TeacherWithClass {//teacher이름, teacher생일, teacher가 맡는 class의 이름을 같이 불러와 저장하는 dto
    private String teacherName;
    private String birthday;
    private String className;

    public TeacherWithClass() {
    }

    public TeacherWithClass(String teacherName, String birthday, String className) {
        this.teacherName = teacherName;
        this.birthday = birthday;
        this.className = className;
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

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

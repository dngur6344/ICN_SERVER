package com.example.practice.diary;

import com.example.practice.student.Student;
import com.example.practice.teacher.Teacher;

import javax.persistence.*;

@Entity(name = "diary")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIARYSEQUENCE") //oracle의 경우 이런식으로 기본키 할당을 해줘야함.
    @SequenceGenerator(sequenceName = "DIARYSEQUENCE", name = "DIARYSEQUENCE", allocationSize = 1)
    private Integer diaryNo;

    @Column(name = "INSERTTIME",nullable = false)
    private String insertTime;

    @Column(name="COMMENTS", nullable = false)
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_no",nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_no",nullable = false)
    private Teacher teacher;

    public Integer getDiaryNo() {
        return diaryNo;
    }

    public void setDiaryNo(Integer diaryNo) {
        this.diaryNo = diaryNo;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Student getStudentEntity() {
        return student;
    }

    public void setStudentEntity(Student student) {
        this.student = student;
    }

    public Teacher getTeacherEntity() {
        return teacher;
    }

    public void setTeacherEntity(Teacher teacher) {
        this.teacher = teacher;
    }
}

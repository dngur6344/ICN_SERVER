package com.example.practice.diary;

import com.example.practice.student.StudentEntity;
import com.example.practice.teacher.TeacherEntity;

import javax.persistence.*;

@Entity(name = "diary")
public class DiaryEntity {
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
    private StudentEntity studentEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_no",nullable = false)
    private TeacherEntity teacherEntity;

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

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }
}

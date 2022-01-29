package com.example.practice.diary;

public class DiaryStudentTeacherDTO {
    String insertTime;
    String comments;
    String studentName;
    String teacherName;

    public DiaryStudentTeacherDTO(String insertTime, String comments, String studentName, String teacherName) {
        this.insertTime = insertTime;
        this.comments = comments;
        this.studentName = studentName;
        this.teacherName = teacherName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

package com.example.practice.student;

public class StudentWithClassDTO {
    private Integer studentNo;
    private String studentName;
    private String birthday;
    private Integer classNo;
    private String className;

    public StudentWithClassDTO() {
    }

    public StudentWithClassDTO(Integer studentNo, String studentName, String birthday, Integer classNo, String className) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.birthday = birthday;
        this.classNo = classNo;
        this.className = className;
    }

    public Integer getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Integer studentNo) {
        this.studentNo = studentNo;
    }

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

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

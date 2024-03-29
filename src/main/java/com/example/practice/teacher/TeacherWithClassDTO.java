package com.example.practice.teacher;

public class TeacherWithClassDTO {//teacher이름, teacher생일, teacher가 맡는 class의 이름을 같이 불러와 저장하는 dto
    private Integer teacherNo;
    private String teacherName;
    private String birthday;
    private String className;
    private Integer classNo;

    public TeacherWithClassDTO() {
    }

    public TeacherWithClassDTO(Integer teacherNo, String teacherName, String birthday, String className, Integer classNo) {
        this.teacherName = teacherName;
        this.birthday = birthday;
        this.className = className;
        this.teacherNo=teacherNo;
        this.classNo=classNo;
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

    public Integer getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(Integer teacherNo) {
        this.teacherNo = teacherNo;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }
}

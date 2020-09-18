package com.example.practice.teacher;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface teacherDAO {
    //@Select("select * from teacher")
    List<teacherDTO> getTeachers();
    void insertTeacher(teacherDTO teacher);
    //void updateTeacher()
}

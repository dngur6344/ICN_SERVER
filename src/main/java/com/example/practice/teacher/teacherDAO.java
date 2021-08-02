package com.example.practice.teacher;

//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface teacherDAO extends JpaRepository<TeacherEntity,Integer>,TeacherCustomRepository{
    /*@Override
    @Query("select new com.example.practice.teacher.teacherDTO(teacherNo,teacherName,birthday) from teacher")
    ArrayList<teacherDTO> findAll();
*/
    public Optional<TeacherEntity> findByTeacherName(String name);
}


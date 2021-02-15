package com.example.practice.teacher;

import com.example.practice.calendar.calendarDTO;
import com.example.practice.classinf.QClassEntity;
import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

public class TeacherCustomRepositoryImpl extends QuerydslRepositorySupport implements TeacherCustomRepository{
    public TeacherCustomRepositoryImpl(){
        super(teacherDTO.class);
    }

    @Override
    public List<TeacherWithClass> findWithClass(){//Class 테이블과 Teacher 테이블을 조인하여 각 teacher가 어떤 class를 맡고있는지 알려줌.
        final com.example.practice.teacher.QteacherDTO teacherdto = QteacherDTO.teacherDTO;
        final com.example.practice.classinf.QClassEntity classEntity = QClassEntity.classEntity;
        List<Tuple> res=from(teacherdto).select(teacherdto.teacherName,teacherdto.birthday,classEntity.classname)
                .join(teacherdto.classEntity,classEntity).fetch();//여러 테이블의 필드를 가져오므로 List<Tuple>로 받은뒤 새로 생성한 DTO에는 밑에서 넣어준다.

        List<TeacherWithClass> teachers = new ArrayList<TeacherWithClass>();
        for (Tuple teacher : res) {
            TeacherWithClass instance = new TeacherWithClass(teacher.get(teacherdto.teacherName),teacher.get(teacherdto.birthday),teacher.get(classEntity.classname));
            teachers.add(instance);//새로 만든 TeacherWithClass라는 DTO로 값을 받는 상황
        }
        return teachers;
    }
}

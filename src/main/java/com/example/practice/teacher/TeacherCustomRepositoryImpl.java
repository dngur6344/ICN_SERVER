package com.example.practice.teacher;

import com.example.practice.classinf.QClassEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

public class TeacherCustomRepositoryImpl extends QuerydslRepositorySupport implements TeacherCustomRepository{
    public TeacherCustomRepositoryImpl(){
        super(TeacherEntity.class);
    }

    @Override
    public List<TeacherWithClassDTO> findWithClass(){//Class 테이블과 Teacher 테이블을 조인하여 각 teacher가 어떤 class를 맡고있는지 알려줌.
        final com.example.practice.teacher.QTeacherEntity teacherEntity = QTeacherEntity.teacherEntity;
        final com.example.practice.classinf.QClassEntity classEntity = QClassEntity.classEntity;
        List<TeacherWithClassDTO> res=from(teacherEntity)
                .select(Projections.constructor(
                        TeacherWithClassDTO.class
                        ,teacherEntity.teacherNo
                        ,teacherEntity.teacherName
                        ,teacherEntity.birthday
                        ,classEntity.classname
                        ,classEntity.classNo))
                .join(teacherEntity.classEntity,classEntity).fetch();//여러 테이블의 필드를 가져오므로 List<Tuple>로 받은뒤 새로 생성한 DTO에는 밑에서 넣어준다.

        return res;
    }
}

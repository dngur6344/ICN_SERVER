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
                .join(teacherEntity.classEntity,classEntity)
                .fetch();

        /*** fetch Join을 안해도 N+1 문제가 발생하지 않는다. (selet를 사용하게 되면 Entity가 아닌, Tuple이나 dto로 받아오는 방식이기 때문에 그런 것 같다.)
         *   물론 select 없이 from만 사용하게 될 때에는 N+1 문제가 발생한다.(이때는 from 에 있는 entity 자체를 가져와서 처리하기 떄문인듯) ***/

        return res;
    }
}

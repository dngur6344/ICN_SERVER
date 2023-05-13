package com.example.practice.student;


import com.example.practice.classinf.QClassEntity;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

public class StudentCustomRepositoryImpl extends QuerydslRepositorySupport implements StudentCustomRepository {
    public StudentCustomRepositoryImpl(){
        super(Student.class);
    }

    @Override
    public ArrayList<StudentWithClassDTO> findWithClassAll(){
        com.example.practice.student.QStudentEntity studentEntity = QStudentEntity.studentEntity;
        com.example.practice.classinf.QClassEntity classEntity = QClassEntity.classEntity;

        List<StudentWithClassDTO> res = from(studentEntity)
                .select(Projections.constructor(
                        StudentWithClassDTO.class
                        ,studentEntity.studentNo
                        ,studentEntity.studentName
                        ,studentEntity.birthday
                        ,classEntity.classNo
                        ,classEntity.classname))
                .join(studentEntity.classEntity,classEntity)
                //.fetchJoin()
                .fetch();

        return (ArrayList<StudentWithClassDTO>) res;
    }

    @Override
    public ArrayList<StudentWithClassDTO> findByClassName(String className) {
        com.example.practice.student.QStudentEntity studentEntity = QStudentEntity.studentEntity;
        com.example.practice.classinf.QClassEntity classEntity = QClassEntity.classEntity;

        List<StudentWithClassDTO> res = from(studentEntity)
                .select(Projections.constructor(
                        StudentWithClassDTO.class
                        ,studentEntity.studentNo
                        ,studentEntity.studentName
                        ,studentEntity.birthday
                        ,classEntity.classNo
                        ,classEntity.classname))
                .join(studentEntity.classEntity,classEntity)
                .where(studentEntity.classEntity.classname.eq(className))
                .fetch();

        /*** fetch Join을 안해도 N+1 문제가 발생하지 않는다. (selet를 사용하게 되면 Entity가 아닌, Tuple이나 dto로 받아오는 방식이기 때문에 그런 것 같다.)
         *   물론 select 없이 from만 사용하게 될 때에는 N+1 문제가 발생한다.(이때는 from 에 있는 entity 자체를 가져와서 처리하기 떄문인듯) ***/

        return (ArrayList<StudentWithClassDTO>) res;
    }


}

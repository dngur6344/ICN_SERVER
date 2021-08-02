package com.example.practice.student;


import com.example.practice.classinf.QClassEntity;
import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

public class StudentCustomRepositoryImpl extends QuerydslRepositorySupport implements StudentCustomRepository {
    public StudentCustomRepositoryImpl(){
        super(StudentEntity.class);
    }

    @Override
    public ArrayList<StudentWithClassDTO> findWithClassAll(){
        com.example.practice.student.QStudentEntity studentEntity = QStudentEntity.studentEntity;
        com.example.practice.classinf.QClassEntity classEntity = QClassEntity.classEntity;

        List<Tuple> res = from(studentEntity)
                .select(studentEntity.studentNo
                        ,studentEntity.studentName
                        ,studentEntity.birthday
                        ,classEntity.classNo
                        ,classEntity.classname)
                .join(studentEntity.classEntity,classEntity).fetch();

        ArrayList<StudentWithClassDTO> real = new ArrayList<StudentWithClassDTO>();

        for(Tuple student: res){
            StudentWithClassDTO student_val = new StudentWithClassDTO(
                    student.get(studentEntity.studentNo)
                    ,student.get(studentEntity.studentName)
                    ,student.get(studentEntity.birthday)
                    ,student.get(classEntity.classNo)
                    ,student.get(classEntity.classname)
            );
            real.add(student_val);
        }
        return real;
    }
}

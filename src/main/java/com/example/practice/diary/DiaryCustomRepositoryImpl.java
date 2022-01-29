package com.example.practice.diary;

import com.example.practice.student.QStudentEntity;
import com.example.practice.teacher.QTeacherEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import com.example.practice.diary.QDiaryEntity;

import java.util.ArrayList;
import java.util.List;

public class DiaryCustomRepositoryImpl extends QuerydslRepositorySupport implements DiaryCustomRepository {
    public DiaryCustomRepositoryImpl() {
        super(DiaryEntity.class);
    }

    @Override
    public List<DiaryStudentTeacherDTO> findByStudentNo(Integer studentNo) {
        QDiaryEntity qDiaryEntity = QDiaryEntity.diaryEntity;
        QTeacherEntity qTeacherEntity = QTeacherEntity.teacherEntity;
        QStudentEntity qStudentEntity = QStudentEntity.studentEntity;

        List<DiaryStudentTeacherDTO> res = from(qDiaryEntity)
                .select(Projections.constructor(DiaryStudentTeacherDTO.class,
                        qDiaryEntity.insertTime,
                        qDiaryEntity.comments,
                        qStudentEntity.studentName,
                        qTeacherEntity.teacherName))
                .innerJoin(qDiaryEntity.studentEntity,qStudentEntity)
                .innerJoin(qDiaryEntity.teacherEntity,qTeacherEntity)
                .where(qStudentEntity.studentNo.eq(studentNo))
                .fetch();

        return res;
    }
}

package com.example.practice.diary;

import com.example.practice.student.QStudent;
import com.example.practice.teacher.QTeacherEntity;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class DiaryCustomRepositoryImpl extends QuerydslRepositorySupport implements DiaryCustomRepository {
    public DiaryCustomRepositoryImpl() {
        super(DiaryEntity.class);
    }

    @Override
    public List<DiaryStudentTeacherDTO> findByStudentNo(Integer studentNo) {
        QDiaryEntity qDiaryEntity = QDiaryEntity.diaryEntity;
        QTeacherEntity qTeacherEntity = QTeacherEntity.teacherEntity;
        QStudent qStudent = QStudent.student;

        List<DiaryStudentTeacherDTO> res = from(qDiaryEntity)
                .select(Projections.constructor(DiaryStudentTeacherDTO.class,
                        qDiaryEntity.insertTime,
                        qDiaryEntity.comments,
                        qStudent.studentName,
                        qTeacherEntity.teacherName))
                .innerJoin(qDiaryEntity.student,qStudent)
                .innerJoin(qDiaryEntity.teacherEntity,qTeacherEntity)
                .where(qStudent.studentNo.eq(studentNo))
                .fetch();

        return res;
    }
}

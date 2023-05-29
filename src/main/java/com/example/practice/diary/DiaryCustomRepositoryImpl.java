package com.example.practice.diary;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static com.example.practice.diary.QDiary.diary;
import static com.example.practice.student.QStudent.student;
import static com.example.practice.teacher.QTeacher.teacher;

public class DiaryCustomRepositoryImpl implements DiaryCustomRepository {

    private JPAQueryFactory jpaQueryFactory;

    public DiaryCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<DiaryStudentTeacherDTO> findByStudentNo(Integer studentNo) {

        List<DiaryStudentTeacherDTO> res = jpaQueryFactory.selectFrom(diary)
                .select(Projections.constructor(DiaryStudentTeacherDTO.class,
                        diary.insertTime,
                        diary.comments,
                        student.studentName,
                        teacher.teacherName))
                .innerJoin(diary.student, student)
                .innerJoin(diary.teacher, teacher)
                .where(student.studentNo.eq(studentNo))
                .fetch();

        return res;
    }
}

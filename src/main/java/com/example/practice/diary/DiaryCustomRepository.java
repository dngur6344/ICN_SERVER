package com.example.practice.diary;

import com.querydsl.core.Tuple;

import java.util.List;

public interface DiaryCustomRepository {
    public List<DiaryStudentTeacherDTO> findByStudentNo(Integer studentNo);
}

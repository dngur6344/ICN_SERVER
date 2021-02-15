package com.example.practice.teacher;

import com.querydsl.core.Tuple;

import java.util.ArrayList;
import java.util.List;

public interface TeacherCustomRepository {
    public List<TeacherWithClass> findWithClass();//Teacher와 Class name을 함께 갖고 있는 결과를 가져오기 위한 메소드
}

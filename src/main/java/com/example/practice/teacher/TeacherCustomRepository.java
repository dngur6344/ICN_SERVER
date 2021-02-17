package com.example.practice.teacher;

import java.util.List;

public interface TeacherCustomRepository {
    public List<TeacherWithClassDTO> findWithClass();//Teacher와 Class name을 함께 갖고 있는 결과를 가져오기 위한 메소드
}

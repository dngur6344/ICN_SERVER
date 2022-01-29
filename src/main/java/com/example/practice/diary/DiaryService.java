package com.example.practice.diary;

import com.example.practice.student.StudentRepository;
import com.example.practice.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DiaryService {
    @Autowired
    DiaryRepository diaryRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<DiaryStudentTeacherDTO> findByStudentNo(Integer studentNo){
        return diaryRepository.findByStudentNo(studentNo);
    }

    public void insertDiary(Map<String,Object> map){
        Integer userId = Integer.parseInt(map.get("userId").toString());
        Integer studentId = Integer.parseInt(map.get("studentId").toString());
        String insertTime = map.get("insertTime").toString();
        String comments = map.get("comments").toString();

        DiaryEntity diaryEntity = new DiaryEntity();

        diaryEntity.setInsertTime(insertTime);
        diaryEntity.setComments(comments);
        diaryEntity.setStudentEntity(studentRepository.findById(studentId).get());
        diaryEntity.setTeacherEntity(teacherRepository.findById(userId).get());

        diaryRepository.save(diaryEntity);
    }
}

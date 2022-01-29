package com.example.practice.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @RequestMapping("/search/{studentNo}")
    public List<DiaryStudentTeacherDTO> findByStudentNo(@PathVariable(name = "studentNo") Integer studentNo){
        return diaryService.findByStudentNo(studentNo);
    }

    @RequestMapping("/register")
    public void InsertDiary(@RequestBody Map<String,Object> body){
        diaryService.insertDiary(body);
    }
}

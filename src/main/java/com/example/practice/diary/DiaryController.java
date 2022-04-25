package com.example.practice.diary;

import com.example.practice.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @RequestMapping("/search/{studentNo}")
    public ResponseEntity<ResponseMessage> findByStudentNo(@PathVariable(name = "studentNo") Integer studentNo){
        List<DiaryStudentTeacherDTO> diaryList = diaryService.findByStudentNo(studentNo);
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(diaryList)
                .build();

        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @RequestMapping("/register")
    public void InsertDiary(@RequestBody Map<String,Object> body){
        diaryService.insertDiary(body);
    }
}

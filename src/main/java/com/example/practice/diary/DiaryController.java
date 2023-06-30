package com.example.practice.diary;

import com.example.practice.response.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @RequestMapping("/search/{studentNo}")
    public ResponseEntity<ResponseMessage> findByStudentNo(@PathVariable(name = "studentNo") Integer studentNo){
        List<DiaryStudentTeacherDTO> diaryList = diaryService.findByStudentNo(studentNo);
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data(diaryList)
                .build();

        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.OK);
    }

    @PostMapping
    public void createDiary(@RequestBody Map<String,Object> body){
        diaryService.createDiary(body);
    }
}

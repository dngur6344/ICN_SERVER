package com.example.practice.diary.vo;

import lombok.Getter;

@Getter
public class CreateDiaryRequestVO {
    Integer userId;
    Integer studentId;
    String insertTime;
    String comments;
}

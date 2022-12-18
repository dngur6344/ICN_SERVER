package com.example.practice.handler;

import com.example.practice.response.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseMessage> handleRegisterContentException(RuntimeException e){
        ResponseMessage responseMessage = ResponseMessage.builder()
                .responseTime(new Date())
                .data("에러가 발생하였습니다.!!")
                .build();

        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.FORBIDDEN);
    }
}

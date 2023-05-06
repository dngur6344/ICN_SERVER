package com.example.practice;

//import com.example.practice.score.ScoreRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.TimeZone;

//@EnableJpaRepositories(excludeFilters = @ComponentScan.Filter(
//        type = FilterType.ASSIGNABLE_TYPE,
//        classes = ScoreRepository.class))
@SpringBootApplication
public class PracticeApplication {
    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println("현재시간 : " + new Date());
    }

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

}

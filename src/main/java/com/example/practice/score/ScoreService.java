//package com.example.practice.score;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ScoreService {
//
//    @Autowired
//    ScoreRepository scoreRepository;
//
//    public void save(ScoreDTO scoreDTO){
//        ScoreEntity scoreEntity = new ScoreEntity(
//                scoreDTO.getRegtime(),
//                scoreDTO.getName(),
//                scoreDTO.getScore()
//        );
//
//        scoreRepository.save(scoreEntity);
//    }
//}

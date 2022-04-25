package com.example.practice.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @PostMapping("/register")
    public void save(@RequestBody ScoreDTO scoreDTO){

    }
}

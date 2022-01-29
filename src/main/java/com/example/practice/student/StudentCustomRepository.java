package com.example.practice.student;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;

public interface StudentCustomRepository {
    public ArrayList<StudentWithClassDTO> findWithClassAll();
    public ArrayList<StudentWithClassDTO> findByClassName(String className);
}

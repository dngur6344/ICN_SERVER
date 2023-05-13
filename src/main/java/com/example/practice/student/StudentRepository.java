package com.example.practice.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer>,StudentCustomRepository{
}

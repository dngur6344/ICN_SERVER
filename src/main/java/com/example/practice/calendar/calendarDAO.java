package com.example.practice.calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface calendarDAO extends JpaRepository<calendarDTO,Integer> {
}
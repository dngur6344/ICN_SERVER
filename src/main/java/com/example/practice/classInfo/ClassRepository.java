package com.example.practice.classInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassInfo,Integer> {
    public ClassInfo findByClassname(String name);
}

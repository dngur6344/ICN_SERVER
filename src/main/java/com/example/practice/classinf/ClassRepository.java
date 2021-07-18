package com.example.practice.classinf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity,Integer> {
    public ClassEntity findByClassname(String name);
}

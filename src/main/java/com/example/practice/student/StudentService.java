package com.example.practice.student;

import com.example.practice.classInfo.ClassInfo;
import com.example.practice.classInfo.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    @Transactional(readOnly = true)
    public ArrayList<StudentWithClassDTO> findWithClassAll() {
        return studentRepository.findWithClassAll();

    }

    @Transactional
    public void createStudent(StudentCreateRequestDTO studentCreateRequestDTO) {
        ClassInfo aClassInfo = classRepository.findByClassname(studentCreateRequestDTO.getClassName());
        Student student = Student.of(studentCreateRequestDTO, aClassInfo);

        studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public ArrayList<StudentWithClassDTO> findByClassName(String className) {
        return studentRepository.findByClassName(className);
    }
}

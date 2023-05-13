package com.example.practice.student;

import com.example.practice.classinf.ClassEntity;
import com.example.practice.diary.DiaryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENTSEQUENCE") //oracle의 경우 이런식으로 기본키 할당을 해줘야함.
    @SequenceGenerator(sequenceName = "STUDENTSEQUENCE", name = "STUDENTSEQUENCE", allocationSize = 1)
    private Integer studentNo;

    @Column(length = 100,nullable = false)
    private String studentName;

    @Column(length=100,nullable = false)
    private String birthday;

    @ManyToOne(fetch=FetchType.LAZY)//Lazy로 해두어서 직접 접근하기 전까진 N+1 상황이 일어나지 않음.
    @JoinColumn(name="class_no",nullable=false,updatable=false)
    private ClassEntity classEntity;

    @OneToMany
    @JoinColumn(name="diaryNo")
    private List<DiaryEntity> diaries = new ArrayList<>();

    @Builder
    public Student(String studentName, String birthday, ClassEntity classEntity, List<DiaryEntity> diaries) {
        this.studentName = studentName;
        this.birthday = birthday;
        this.classEntity = classEntity;
        this.diaries = diaries;
    }

    public static Student of(StudentCreateRequestDTO dto, ClassEntity classEntity) {
        Student student = Student.builder()
                .studentName(dto.getName())
                .birthday(dto.getBirthday())
                .classEntity(classEntity)
                .build();

        return student;
    }
}

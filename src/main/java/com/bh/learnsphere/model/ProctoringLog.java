package com.bh.learnsphere.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class ProctoringLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    @Setter
    @Getter
    private Long quizId;

    @Setter
    @Getter
    private LocalDateTime timestamp;
    private String message;


}

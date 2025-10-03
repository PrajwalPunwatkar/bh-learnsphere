package com.bh.learnsphere.model;

import jakarta.persistence.*;

@Entity
public class SubmissionAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Submission submission;

    @ManyToOne
    private Question question;

    private String answer; // Student’s answer

    private boolean correct;
}
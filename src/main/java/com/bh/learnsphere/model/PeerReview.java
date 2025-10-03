package com.bh.learnsphere.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeerReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;   // Which assignment
    private Long reviewerId;     // Student who reviewed
    private Long revieweeId;     // Student whose work is reviewed

    private String criterion;    // Rubric criterion name
    private int score;           // Score given
    private String comments;

    private LocalDateTime reviewedAt;
}

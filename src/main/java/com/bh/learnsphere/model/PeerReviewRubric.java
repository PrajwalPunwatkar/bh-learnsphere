package com.bh.learnsphere.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeerReviewRubric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String criterion;   // e.g., "Clarity"
    private int maxScore;       // e.g., 5
}

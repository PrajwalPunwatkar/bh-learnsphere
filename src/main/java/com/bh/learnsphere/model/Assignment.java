package com.bh.learnsphere.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courseId; // Link to Course

    private String title;
    private String description;

    private LocalDateTime dueDate;

    private Integer maxMarks; // e.g., 100
}

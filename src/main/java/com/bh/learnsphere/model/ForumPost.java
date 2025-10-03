package com.bh.learnsphere.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForumPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long courseId;   // Forum is linked to a course
    private Long userId;     // Who posted

    private String content;  // Post text
    private Long parentPostId; // For replies (null = top-level post)

    private LocalDateTime createdAt;
}

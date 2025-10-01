package com.bh.learnsphere.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContentType contentType; // VIDEO, PDF, TEXT, LINK

    private String contentUrl; // for video/pdf/link

    @Column(length = 5000)
    private String textData; // for text-based content

    private LocalDateTime releaseDate; // drip content

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}


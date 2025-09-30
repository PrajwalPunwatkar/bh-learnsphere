package com.bh.learnsphere.model;

import com.bh.learnsphere.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String category;

    private String level; // Beginner, Intermediate, Advanced

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    private boolean published = false;
}

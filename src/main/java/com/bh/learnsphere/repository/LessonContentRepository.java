package com.bh.learnsphere.repository;

import com.bh.learnsphere.model.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonContentRepository extends JpaRepository<LessonContent, Long> {
    List<LessonContent> findByLessonIdAndReleaseDateBefore(Long lessonId, java.time.LocalDateTime now);
}


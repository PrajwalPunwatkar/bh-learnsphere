package com.bh.learnsphere.service;

import com.bh.learnsphere.model.LessonContent;
import com.bh.learnsphere.repository.LessonContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonContentService {

    private final LessonContentRepository contentRepository;

    public LessonContent addContent(LessonContent content) {
        return contentRepository.save(content);
    }

    // Drip Content: Only return content already released
    public List<LessonContent> getAvailableContent(Long lessonId) {
        return contentRepository.findByLessonIdAndReleaseDateBefore(lessonId, LocalDateTime.now());
    }
}



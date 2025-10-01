package com.bh.learnsphere.controller;

import com.bh.learnsphere.model.LessonContent;
import com.bh.learnsphere.service.LessonContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
@RequiredArgsConstructor
public class LessonContentController {

    private final LessonContentService contentService;

    @PostMapping
    public ResponseEntity<LessonContent> addContent(@RequestBody LessonContent content) {
        return ResponseEntity.ok(contentService.addContent(content));
    }

    // Drip content support
    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<LessonContent>> getAvailableContent(@PathVariable Long lessonId) {
        return ResponseEntity.ok(contentService.getAvailableContent(lessonId));
    }
}

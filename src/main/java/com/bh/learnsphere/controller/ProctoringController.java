package com.bh.learnsphere.controller;

import com.bh.learnsphere.model.ProctoringLog;
import com.bh.learnsphere.repository.ProctoringLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/proctoring")
@RequiredArgsConstructor
public class ProctoringController {

    private final ProctoringLogRepository logRepository;

    @PostMapping("/log")
    public ResponseEntity<String> logEvent(@RequestBody ProctoringLog log) {
        log.setTimestamp(LocalDateTime.now());
        logRepository.save(log);
        return ResponseEntity.ok("Proctoring log saved");
    }

    @GetMapping("/quiz/{quizId}")
    public List<ProctoringLog> getLogsByQuiz(@PathVariable Long quizId) {
        return logRepository.findAll()
                .stream()
                .filter(log -> log.getQuizId().equals(quizId))
                .toList();
    }
}

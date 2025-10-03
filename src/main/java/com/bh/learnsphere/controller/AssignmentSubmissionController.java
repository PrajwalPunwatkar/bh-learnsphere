package com.bh.learnsphere.controller;

import com.bh.learnsphere.model.AssignmentSubmission;
import com.bh.learnsphere.service.AssignmentSubmissionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class AssignmentSubmissionController {
    private final AssignmentSubmissionService submissionService;

    public AssignmentSubmissionController(AssignmentSubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping("/upload")
    public AssignmentSubmission submitAssignment(
            @RequestParam("assignmentId") Long assignmentId,
            @RequestParam("studentId") Long studentId,
            @RequestParam("file") MultipartFile file) throws IOException {

        String uploadDir = "uploads/assignments/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String filePath = uploadDir + file.getOriginalFilename();
        file.transferTo(new File(filePath));

        AssignmentSubmission submission = AssignmentSubmission.builder()
                .assignmentId(assignmentId)
                .studentId(studentId)
                .filePath(filePath)
                .build();

        return submissionService.submitAssignment(submission);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentSubmission> getSubmissionsByAssignment(@PathVariable Long assignmentId) {
        return submissionService.getSubmissionsByAssignment(assignmentId);
    }

    @PostMapping("/{submissionId}/grade")
    public AssignmentSubmission gradeSubmission(
            @PathVariable Long submissionId,
            @RequestParam int marks,
            @RequestParam String feedback) {
        return submissionService.gradeSubmission(submissionId, marks, feedback);
    }
}

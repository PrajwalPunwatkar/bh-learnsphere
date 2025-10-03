package com.bh.learnsphere.service;

import com.bh.learnsphere.model.AssignmentSubmission;
import com.bh.learnsphere.repository.AssignmentSubmissionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssignmentSubmissionService {
    private final AssignmentSubmissionRepository submissionRepository;

    public AssignmentSubmissionService(AssignmentSubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    public AssignmentSubmission submitAssignment(AssignmentSubmission submission) {
        submission.setSubmittedAt(LocalDateTime.now());
        return submissionRepository.save(submission);
    }

    public List<AssignmentSubmission> getSubmissionsByAssignment(Long assignmentId) {
        return submissionRepository.findByAssignmentId(assignmentId);
    }

    public AssignmentSubmission gradeSubmission(Long submissionId, int marks, String feedback) {
        AssignmentSubmission sub = submissionRepository.findById(submissionId).orElseThrow();
        sub.setMarksObtained(marks);
        sub.setFeedback(feedback);
        return submissionRepository.save(sub);
    }
}

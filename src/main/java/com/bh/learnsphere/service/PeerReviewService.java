package com.bh.learnsphere.service;

import com.bh.learnsphere.model.PeerReview;
import com.bh.learnsphere.repository.PeerReviewRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeerReviewService {

    private final PeerReviewRepository reviewRepo;

    public PeerReviewService(PeerReviewRepository reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public PeerReview submitReview(PeerReview review) {
        review.setReviewedAt(LocalDateTime.now());
        return reviewRepo.save(review);
    }

    public List<PeerReview> getReviewsForAssignment(Long assignmentId) {
        return reviewRepo.findByAssignmentId(assignmentId);
    }

    public List<PeerReview> getReviewsForStudent(Long revieweeId) {
        return reviewRepo.findByRevieweeId(revieweeId);
    }
}

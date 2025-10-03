package com.bh.learnsphere.controller;

import com.bh.learnsphere.model.PeerReview;
import com.bh.learnsphere.service.PeerReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peer-review")
public class PeerReviewController {

    private final PeerReviewService reviewService;

    public PeerReviewController(PeerReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/submit")
    public PeerReview submitReview(@RequestBody PeerReview review) {
        return reviewService.submitReview(review);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<PeerReview> getReviewsForAssignment(@PathVariable Long assignmentId) {
        return reviewService.getReviewsForAssignment(assignmentId);
    }

    @GetMapping("/student/{revieweeId}")
    public List<PeerReview> getReviewsForStudent(@PathVariable Long revieweeId) {
        return reviewService.getReviewsForStudent(revieweeId);
    }
}

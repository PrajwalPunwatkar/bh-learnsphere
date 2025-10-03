package com.bh.learnsphere.repository;



import com.bh.learnsphere.model.PeerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeerReviewRepository extends JpaRepository<PeerReview, Long> {
    List<PeerReview> findByAssignmentId(Long assignmentId);
    List<PeerReview> findByRevieweeId(Long revieweeId);
    List<PeerReview> findByReviewerId(Long reviewerId);
}


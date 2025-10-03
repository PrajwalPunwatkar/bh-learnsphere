package com.bh.learnsphere.service;

import com.bh.learnsphere.model.Assignment;
import com.bh.learnsphere.repository.AssignmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAssignmentsByCourse(Long courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    public Assignment getAssignment(Long id) {
        return assignmentRepository.findById(id).orElseThrow();
    }
}

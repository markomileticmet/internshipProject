package com.example.internshipProject.repository;

import com.example.internshipProject.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByFullName(String fullName);
}

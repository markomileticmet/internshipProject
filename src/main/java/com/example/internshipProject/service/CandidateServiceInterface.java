package com.example.internshipProject.service;

import com.example.internshipProject.model.Candidate;

import java.util.List;

public interface CandidateServiceInterface {
    Candidate create(Candidate candidate);
    List<Candidate> list();
    Candidate get(Long employeeId);
    Candidate findByFullName(String fullName);
    Candidate updateSkill(Long candidateId, Long skillId);
    Candidate deleteSkill(Long candidateId, Long skillId);
    List<Candidate> filterBySkills(List<Long> skillIds);
    void delete(Long id);
}

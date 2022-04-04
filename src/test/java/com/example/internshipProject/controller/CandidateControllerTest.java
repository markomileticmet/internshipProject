package com.example.internshipProject.controller;

import com.example.internshipProject.model.Candidate;
import com.example.internshipProject.model.Skill;
import com.example.internshipProject.service.implementation.CandidateService;
import com.example.internshipProject.service.implementation.SkillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CandidateControllerTest {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private SkillService skillService;

    @Test
    void createRestApi_ShouldCreateCandidate_IfDataNotNull() {
        Candidate candidate = new Candidate(
                null,
                "James Smith",
                "04/03/1988",
                "0602315469",
                "jamessmithemail@gmail.com",
                null
        );
        candidateService.create(candidate);
        assertNotNull(candidateService.get(candidate.getCandidateId()));
    }

    @Test
    void listRestApi_ShouldListCandidates_IfListNotNull() {
        Candidate c1 = new Candidate(
                null,
                "James Smith",
                "04/03/1988",
                "0602315469",
                "jamessmithemail@gmail.com",
                null
        );
        Candidate c2 = new Candidate(
                null,
                "James Smith",
                "04/03/1988",
                "0602315469",
                "jamessmithemail@gmail.com",
                null
        );
        candidateService.create(c1);
        candidateService.create(c2);
        assertNotNull(candidateService.list().isEmpty());
    }

    @Test
    void getRestApi_ShouldGetCandidateById_IfCandidateIdNull() {
        Candidate c1 = new Candidate(
                null,
                "James Smith",
                "04/03/1988",
                "0602315469",
                "jamessmithemail@gmail.com",
                null
        );
        candidateService.create(c1);
        assertNotNull(candidateService.get(4L));
    }

    @Test
    void updateSkillRestApi_ShouldUpdateCandidateSkill_IfCandidateOrSkillIsNotNull() {
        Skill s1 = new Skill(
                null,
                "Javascript"
        );
        Candidate c1 = new Candidate(
                null,
                "James Smith",
                "04/03/1988",
                "0602315469",
                "jamessmithemail@gmail.com",
                null
        );
        candidateService.create(c1);
        skillService.createSkill(s1);
        assertNotNull(candidateService.updateSkill(4L, 1L));
    }

    @Test
    void deleteSkillRestApi_ShouldDeleteCandidateSkill_IfCandidateOrSkillIsNotNull() {
        Skill s1 = new Skill(
                null,
                "Javascript"
        );
        Candidate c1 = new Candidate(
                null,
                "James Smith",
                "04/03/1988",
                "0602315469",
                "jamessmithemail@gmail.com",
                null
        );
        candidateService.updateSkill(4L, 1L);
        assertNotNull(candidateService.deleteSkill(4L, 1L));
    }
}
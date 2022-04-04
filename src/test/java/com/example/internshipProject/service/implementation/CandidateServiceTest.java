package com.example.internshipProject.service.implementation;

import com.example.internshipProject.model.Candidate;
import com.example.internshipProject.model.Skill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CandidateServiceTest {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private SkillService skillService;


    @Test
    void createServiceLayer_ShouldCreateCandidate_IfDataNotNull() {
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
    void listServiceLayer_ShouldListCandidates_IfListNotNull() {
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
    void getServiceLayer_ShouldGetCandidateById_IfCandidateIdNull() {
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
    void updateSkillServiceLayer_ShouldUpdateCandidateSkill_IfCandidateOrSkillIsNotNull() {
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
    void deleteSkillServiceLayer_ShouldDeleteCandidateSkill_IfCandidateOrSkillIsNotNull() {
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
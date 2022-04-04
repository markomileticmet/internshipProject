package com.example.internshipProject.controller;


import com.example.internshipProject.model.Candidate;
import com.example.internshipProject.service.implementation.CandidateService;
import com.example.internshipProject.views.CandidateView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<CandidateView>> getCandidates() {
        List<Candidate> candidateList = candidateService.list();
        List<CandidateView> candidateViewList = new ArrayList<>();
        for (Candidate c : candidateList) {
            candidateViewList.add(new CandidateView()
                    .withFullname(c.getFullName())
                    .withBirthDate(c.getBirthDate())
                    .withContactNumber(c.getContactNumber())
                    .withEmail(c.getEmail())
                    .withSkills(c.getSkills()));
        }
        return new ResponseEntity<>(candidateViewList, HttpStatus.OK);
    }

    @GetMapping(value = "/{fullName}")
    public Candidate getByCandidateName(@PathVariable(value = "fullName") String fullName) {
        return candidateService.findByFullName(fullName);
    }

    @GetMapping(value = "/{id}")
    public Candidate getCandidate(@PathVariable Long candidateId) {
        return candidateService.get(candidateId);
    }

    @PostMapping(value = "/save")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.create(candidate);
    }

    @PatchMapping(value = "/update-skill")
    public Candidate updateSkills(@RequestParam("candidateId") Long candidateId, @RequestParam("skillId") Long skillId) {
        return candidateService.updateSkill(candidateId, skillId);
    }

    @DeleteMapping(value = "/delete-skill")
    public Candidate deleteSkill(@RequestParam("candidateId") Long candidateId, @RequestParam("skillId") Long skillId) {
        return candidateService.deleteSkill(candidateId, skillId);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<CandidateView>> filterCandidates(@RequestParam("skillId") List<Long> skillIds) {
        List<Candidate> candidateList = candidateService.filterBySkills(skillIds);
        List<CandidateView> candidateViewList = new ArrayList<>();
        for (Candidate c : candidateList) {
            candidateViewList.add(new CandidateView()
                    .withFullname(c.getFullName())
                    .withBirthDate(c.getBirthDate())
                    .withContactNumber(c.getContactNumber())
                    .withEmail(c.getEmail())
                    .withSkills(c.getSkills()));
        }
        return new ResponseEntity<>(candidateViewList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCandidate(@PathVariable Long candidateId) {
        candidateService.delete(candidateId);
    }

}

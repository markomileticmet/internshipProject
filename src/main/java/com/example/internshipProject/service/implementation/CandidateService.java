package com.example.internshipProject.service.implementation;

import com.example.internshipProject.model.Candidate;
import com.example.internshipProject.model.Skill;
import com.example.internshipProject.repository.CandidateRepository;
import com.example.internshipProject.repository.SkillRepository;
import com.example.internshipProject.service.CandidateServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Transactional

public class CandidateService implements CandidateServiceInterface {

    private final CandidateRepository candidateRepository;
    private final SkillRepository skillRepository;

    @Override
    public Candidate create(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> list() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate get(Long candidateId) {
        return candidateRepository.findById(candidateId).get();
    }

    @Override
    public Candidate findByFullName(String fullName) {
        return candidateRepository.findByFullName(fullName);
    }

    @Override
    public Candidate updateSkill(Long candidateId, Long skillId) {
        Candidate candidate = candidateRepository.getById(candidateId);
        Skill skill = skillRepository.getById(skillId);
        List<Skill> skills = candidate.getSkills();
        skills.add(skill);
        candidate.setSkills(skills);
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate deleteSkill(Long candidateId, Long skillId) {
        Candidate candidate = candidateRepository.getById(candidateId);
        Skill skill = skillRepository.getById(skillId);
        List<Skill> skills = candidate.getSkills();
        skills.remove(skill);
        candidate.setSkills(skills);
        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> filterBySkills(List<Long> skillIds) {
        List<Candidate> candidateList = candidateRepository.findAll();
        List<Candidate> candidateFilterList = new ArrayList<>();
        for(Candidate c:candidateList){
            for (Long skillId : skillIds) {
                List<Skill> filteredSkills =
                        c.getSkills()
                                .stream()
                                .filter(p -> Objects.equals(p.getSkillId(), skillId))
                                .collect(Collectors.toList());
                if (filteredSkills.size() == 0)
                    break;
                candidateFilterList.add(c);
            }
        }
        return candidateFilterList;
    }

    @Override
    public void delete(Long candidateId) {
        candidateRepository.deleteById(candidateId);
    }
}

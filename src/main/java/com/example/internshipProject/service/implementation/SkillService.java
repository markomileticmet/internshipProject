package com.example.internshipProject.service.implementation;

import com.example.internshipProject.model.Skill;
import com.example.internshipProject.repository.SkillRepository;
import com.example.internshipProject.service.SkillsServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class SkillService implements SkillsServiceInterface {
    private final SkillRepository skillRepository;

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }
}

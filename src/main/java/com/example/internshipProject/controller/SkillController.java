package com.example.internshipProject.controller;

import com.example.internshipProject.model.Skill;
import com.example.internshipProject.service.implementation.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;
    @PostMapping(value = "/save")
    public Skill saveSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }
}

package com.example.internshipProject.views;

import com.example.internshipProject.model.Skill;

import java.util.List;


public class CandidateView {
    public String fullname;
    public String birthDate;
    public String contactNumber;
    public String email;
    public List<Skill> skills;

    public CandidateView withFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public CandidateView withBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public CandidateView withContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }
    public CandidateView withEmail(String email) {
        this.email = email;
        return this;
    }
    public CandidateView withSkills(List<Skill> skills) {
        this.skills = skills;
        return this;
    }
}

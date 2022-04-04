package com.example.internshipProject;

import com.example.internshipProject.model.Candidate;
import com.example.internshipProject.model.Skill;
import com.example.internshipProject.repository.CandidateRepository;
import com.example.internshipProject.repository.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class InternshipProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner run(CandidateRepository candidateRepository, SkillRepository skillRepository){
		return args ->{
			skillRepository.save(new Skill(null,"Java"));
			skillRepository.save(new Skill(null,"C#"));
			skillRepository.save(new Skill(null,"English"));
			candidateRepository.save(new Candidate(null,"James Smith","1998-01-32","0602315469","jamessmithemail@gmail.com", null));
		};
	}
}

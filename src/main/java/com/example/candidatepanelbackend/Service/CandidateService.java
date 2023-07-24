package com.example.candidatepanelbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.candidatepanelbackend.Model.Candidate;
import com.example.candidatepanelbackend.Repo.CandidateRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CandidateService {
	
	@Autowired 
	private CandidateRepo candidateRepo;

	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepo.save(candidate);
	}

	public List<Candidate> getCandidate() {
		return candidateRepo.findAll();
		
	}

}

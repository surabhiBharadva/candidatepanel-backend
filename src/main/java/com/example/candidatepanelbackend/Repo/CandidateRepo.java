package com.example.candidatepanelbackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.Model.Candidate;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long>{


	
}

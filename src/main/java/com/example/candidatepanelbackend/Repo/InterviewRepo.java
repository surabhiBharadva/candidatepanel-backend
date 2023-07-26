package com.example.candidatepanelbackend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.Model.Interview;

@Repository
public interface InterviewRepo extends JpaRepository<Interview,Integer> {
	
	
}

package com.example.candidatepanelbackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.Model.Interview;



@Repository
public interface InterviewRepo extends JpaRepository<Interview,Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE status='Scheduled'")
	List<Interview> findTodayInterview();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE candidateId =:cadidateId and status='Selected'")
	Interview checkStatusSelected(Long cadidateId);

	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE candidateId =:candidateId")
	Interview getInterviewBycandidateId(Long candidateId);
	
	
}

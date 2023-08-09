package com.example.candidatepanelbackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.Model.Interview;



@Repository
public interface InterviewRepo extends JpaRepository<Interview,Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE status='InterviewScheduled' and DATE(schduleDateTime) = CURDATE() or DATE(schduleDateTime) < CURDATE()")
	List<Interview> findTodayInterview();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE candidateId =:cadidateId and status='InterviewSelected'")
	Interview checkStatusSelected(Long cadidateId);

	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE candidateId =:candidateId")
	Interview getInterviewBycandidateId(Long candidateId);

	@Query(nativeQuery = true, value = "SELECT * FROM interview where DATE(schduleDateTime) > CURDATE()")
	List<Interview> getTommorowInterviewList();

	@Query(nativeQuery = true, value = "SELECT * FROM interview where DATE(schduleDateTime) < CURDATE()")
	List<Interview> getPreviousInterviewList();
	
	
}

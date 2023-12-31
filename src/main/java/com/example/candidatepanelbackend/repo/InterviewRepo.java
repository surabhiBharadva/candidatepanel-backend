package com.example.candidatepanelbackend.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.Interview;




@Repository
public interface InterviewRepo extends JpaRepository<Interview,Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE (DATE(interviewSlot) = CURDATE()) or (DATE(interviewSlot) < CURDATE() and interviewStatus='InterviewScheduled') order by interviewSlot ASC")
	List<Interview> findTodayInterview();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE candidateId =:cadidateId and interviewStatus='InterviewSelected'")
	Interview checkStatusSelected(Long cadidateId);

	@Query(nativeQuery = true, value = "SELECT * FROM interview WHERE candidateId =:candidateId")
	Interview getInterviewBycandidateId(Long candidateId);

	@Query(nativeQuery = true, value = "SELECT * FROM interview where DATE(interviewSlot) > CURDATE()")
	List<Interview> getTommorowInterviewList();

	@Query(nativeQuery = true, value = "SELECT * FROM interview where DATE(interviewSlot) < CURDATE()")
	List<Interview> getPreviousInterviewList();
	
	
}

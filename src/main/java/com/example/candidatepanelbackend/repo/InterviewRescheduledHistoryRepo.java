package com.example.candidatepanelbackend.repo;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.candidatepanelbackend.entity.Employee;
import com.example.candidatepanelbackend.entity.InterviewRescheduledHistory;



@Repository
public interface InterviewRescheduledHistoryRepo extends JpaRepository<InterviewRescheduledHistory,Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM interviewrescheduledhistory WHERE interviewId =:interviewId")
	public List<InterviewRescheduledHistory> getInterviewbyId(Long interviewId);

	@Query(nativeQuery = true, value = "SELECT * FROM interviewrescheduledhistory WHERE interviewId =:interviewId")
	public List<InterviewRescheduledHistory> getInterviewReseduledDetails(Long interviewId);


}

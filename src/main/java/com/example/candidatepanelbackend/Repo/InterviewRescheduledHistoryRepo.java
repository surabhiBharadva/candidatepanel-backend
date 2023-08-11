package com.example.candidatepanelbackend.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.candidatepanelbackend.Model.InterviewRescheduledHistory;

@Repository
public interface InterviewRescheduledHistoryRepo extends JpaRepository<InterviewRescheduledHistory,Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM interviewrescheduledhistory WHERE interviewId =:interviewId")
	public List<InterviewRescheduledHistory> getInterviewbyId(Long interviewId);

	@Query(nativeQuery = true, value = "SELECT * FROM interviewrescheduledhistory WHERE interviewId =:interviewId")
	public List<InterviewRescheduledHistory> getInterviewReseduledDetails(Long interviewId);

}

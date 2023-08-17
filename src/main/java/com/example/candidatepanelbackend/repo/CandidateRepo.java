package com.example.candidatepanelbackend.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.candidatepanelbackend.entity.Candidate;
import com.example.candidatepanelbackend.responseModels.CandidateModel;



@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus='UnderScreening' or candidateStatus='InterviewScheduled' or candidateStatus='InterviewSelected' or candidateStatus='OfferAccepted' or candidateStatus='InterviewRejected' or candidateStatus='InterviewCancelled' or candidateStatus='InterviewRescheduled' order by applicationDate ASC")
	List<Candidate> findCandidate();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus='UnderScreening' order by applicationDate ASC")
	List<Candidate> getCandidatePendingInterview();

	
	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus =:candidateStatus WHERE id =:candidateId")
	void updateStatusCandidate(Long candidateId,@Param("candidateStatus") String candidateStatus);

	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus=:candidateStatus order by applicationDate ASC")
	List<Candidate> getStatusList(@Param("candidateStatus") String candidateStatus);
	


	
}

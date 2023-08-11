package com.example.candidatepanelbackend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.candidatepanelbackend.Model.Candidate;


@Repository
public interface CandidateRepo extends JpaRepository<Candidate,Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus='UnderScreening' or candidateStatus='InterviewScheduled' or candidateStatus='InterviewSelected' or candidateStatus='OfferAccepted' or candidateStatus='InterviewRejected' or candidateStatus='InterviewCancelled' or candidateStatus='InterviewRescheduled' order by applicationDate ASC")
	List<Candidate> findCandidate();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus='UnderScreening' order by applicationDate ASC")
	List<Candidate> getCandidatePendingInterview();

	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus='InterviewScheduled' WHERE id =:candidateId")
	public void updateStatus(Long candidateId);

	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus='InterviewSelected' WHERE id =:candidateId")
	public void updateStatusCandidateSelected(Long candidateId);


	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus='InterviewRejected' WHERE id =:candidateId")
	public void updateStatusCandidateRejected(Long candidateId);

	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus='InterviewRescheduled' WHERE id =:candidateId")
	public void updateStatusCandidateReschduleInerview(Long candidateId);
	


	
}

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

	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus='Pending' or candidateStatus='Pending-Interview' or candidateStatus='Interview-Selected' or candidateStatus='Offer-Accepted' order by candidateDate ASC")
	List<Candidate> findCandidate();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM candidate WHERE candidateStatus='Pending' order by candidateDate ASC")
	List<Candidate> getCandidatePendingInterview();

	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus='Pending-Interview' WHERE id =:candidateId")
	public void updateStatus(Long candidateId);

	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus='Interview-Selected' WHERE id =:candidateId")
	public void updateStatusCandidateSelected(Long candidateId);


	@Modifying
    @Transactional 
	@Query(nativeQuery = true, value = "UPDATE candidate SET candidateStatus='InterviewRejected' WHERE id =:candidateId")
	public void updateStatusCandidateRejected(Long candidateId);
	


	
}
